package org.juan.empresas.repositories;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.juan.datasource.EmpresasDatasourceService;
import org.juan.empresas.models.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmpresaRepository {

    @Inject
    EmpresasDatasourceService datasourceService;

    public List<Empresa> getBussines() throws RuntimeException {

        AgroalDataSource dataSource = datasourceService.getDataSource();
        try(Connection conn = dataSource.getConnection()){
            String sql = "SELECT e.* FROM EMPRESAS e";
            PreparedStatement stmt = conn.prepareStatement(sql);
            try(ResultSet rs = stmt.executeQuery()){
                List<Empresa> empresas = new ArrayList<>();
                while (rs.next()){
                    Empresa empresa = new Empresa();
                    empresa.id = rs.getInt("EMPRESA_ID");
                    empresa.nombre = rs.getString("NOMBRE_CORTO");
                    empresas.add(empresa);
                }
                return empresas;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
