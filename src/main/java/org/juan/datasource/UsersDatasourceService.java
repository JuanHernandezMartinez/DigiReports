package org.juan.datasource;

import io.agroal.api.AgroalDataSource;
import io.agroal.api.configuration.AgroalDataSourceConfiguration;
import io.agroal.api.configuration.supplier.AgroalConnectionFactoryConfigurationSupplier;
import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class UsersDatasourceService {

    @ConfigProperty(name = "CONFIG_DB_URL")
    String dbUrl;

    public AgroalDataSource getDataSource(String user, String password) {
        return createNewDataSource(user, password);
    }

    private AgroalDataSource createNewDataSource(String user, String password) {
        try {
            String newDbUrl =  dbUrl + "?user=" + user + "&password=" + password;
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
