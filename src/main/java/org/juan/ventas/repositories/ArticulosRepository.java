package org.juan.ventas.repositories;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.juan.datasource.DynamicDatasourceService;
import org.juan.ventas.models.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RequestScoped
public class ArticulosRepository {

    @Inject
    DynamicDatasourceService dataSourceService;

    public Articulo findArticuloByName(String dbName, String name) {
        AgroalDataSource dataSource = dataSourceService.getDataSource(dbName);
        String sql = "SELECT ARTICULO_ID, NOMBRE FROM ARTICULOS WHERE NOMBRE = ? ";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                Articulo articulo = new Articulo();
                while (rs.next()) {
                    articulo.setId(rs.getInt("ARTICULO_ID"));
                    articulo.setNombre(rs.getString("NOMBRE"));
                }
                return articulo;
            } catch (Exception e) {
                throw new Exception("No se encontro el articulo: " + name);
            }
        } catch (Exception e) {
            Log.info(e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
