package org.juan.datasource;

import io.agroal.api.AgroalDataSource;
import io.agroal.api.configuration.AgroalDataSourceConfiguration;
import io.agroal.api.configuration.supplier.AgroalConnectionFactoryConfigurationSupplier;
import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class DynamicDatasourceService {

    @ConfigProperty(name = "DB_URL")
    String dbUrl;

    @ConfigProperty(name = "DB_USER")
    String dbUser;

    @ConfigProperty(name = "DB_PASSWORD")
    String dbPassword;

    private final Map<String, AgroalDataSource> dataSourceCache = new HashMap<>();

//    @Inject
//    AgroalDataSource defaultDataSource;

    public AgroalDataSource getDataSource(String dbName) {
        return dataSourceCache.computeIfAbsent(dbName, this::createNewDataSource);
    }

    private AgroalDataSource createNewDataSource(String dbName) {
        try {
            String newDbUrl =  dbUrl + dbName + ".FDB?user=" + dbUser + "&password=" + dbPassword;
            AgroalDataSourceConfiguration config = new AgroalDataSourceConfigurationSupplier()
                    .dataSourceImplementation(AgroalDataSourceConfiguration.DataSourceImplementation.AGROAL)
                    .connectionPoolConfiguration(cp -> cp
                            .connectionFactoryConfiguration(new AgroalConnectionFactoryConfigurationSupplier()
                                    .jdbcUrl(newDbUrl)
                            )
                            .maxSize(10)
                    )
                    .get();
            Log.info("USANDO DB: " + dbName);
            return AgroalDataSource.from(config);
        } catch (Exception e) {
            throw new RuntimeException("Error creando DataSource para " + dbName, e);
        }
    }

}
