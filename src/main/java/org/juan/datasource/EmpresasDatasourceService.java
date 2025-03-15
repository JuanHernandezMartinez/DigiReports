package org.juan.datasource;

import io.agroal.api.AgroalDataSource;
import io.agroal.api.configuration.AgroalDataSourceConfiguration;
import io.agroal.api.configuration.supplier.AgroalConnectionFactoryConfigurationSupplier;
import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EmpresasDatasourceService {
    @ConfigProperty(name = "CONFIG_DB_URL")
    String dbUrl;

    @ConfigProperty(name = "CONFIG_USER")
    String dbUser;

    @ConfigProperty(name = "CONFIG_PASSWORD")
    String dbPassword;

    private final Map<String, AgroalDataSource> dataSourceCache = new HashMap<>();

    public AgroalDataSource getDataSource() {
        return createNewDataSource(dbUser, dbPassword);
    }

    private AgroalDataSource createNewDataSource(String user, String password) {
        try {
            String newDbUrl =  dbUrl + ".FDB?user=" + user + "&password=" + password;
            AgroalDataSourceConfiguration config = new AgroalDataSourceConfigurationSupplier()
                    .dataSourceImplementation(AgroalDataSourceConfiguration.DataSourceImplementation.AGROAL)
                    .connectionPoolConfiguration(cp -> cp
                            .connectionFactoryConfiguration(new AgroalConnectionFactoryConfigurationSupplier()
                                    .jdbcUrl(newDbUrl)
                            )
                            .maxSize(10)
                    )
                    .get();
            return AgroalDataSource.from(config);
        } catch (Exception e) {
            throw new RuntimeException("Error creando DataSource para ", e);
        }
    }
}
