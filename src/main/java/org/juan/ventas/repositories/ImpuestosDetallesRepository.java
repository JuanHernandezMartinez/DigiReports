package org.juan.ventas.repositories;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.juan.datasource.DynamicDatasourceService;
import org.juan.ventas.models.Impuesto;

@RequestScoped
public class ImpuestosDetallesRepository {

    @Inject
    DynamicDatasourceService datasourceService;

    public List<Impuesto> findImpuestosByDetallesIds(String dbName, List<Integer> detallesIds) {

        List<Impuesto> impuestos = new ArrayList<>();
        if (detallesIds.isEmpty()) {
            return impuestos;
        }

        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);
        var placeholders = detallesIds.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "SELECT IMPUESTO_ID, DOCTO_VE_DET_ID, IMPORTE_IMPUESTO_BRUTO FROM IMPUESTOS_DOCTOS_VE_DET WHERE DOCTO_VE_DET_ID in (" + placeholders + ")";

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < detallesIds.size(); i++) {
                stmt.setInt(i + 1, detallesIds.get(i));
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Impuesto impuesto = new Impuesto();
                    impuesto.setId(rs.getInt("IMPUESTO_ID"));
                    impuesto.setDetalleId(rs.getInt("DOCTO_VE_DET_ID"));
                    impuesto.setImporteImpuesto(rs.getBigDecimal("IMPORTE_IMPUESTO_BRUTO"));
                    impuestos.add(impuesto);
                }
                return impuestos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
