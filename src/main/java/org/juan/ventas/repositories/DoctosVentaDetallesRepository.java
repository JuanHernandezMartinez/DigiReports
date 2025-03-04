package org.juan.ventas.repositories;

import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import org.juan.datasource.DynamicDatasourceService;
import org.juan.ventas.dtos.ArticuloTotal;
import org.juan.ventas.models.DoctosVentaDetalles;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DoctosVentaDetallesRepository {

    @Inject
    DynamicDatasourceService datasourceService;


    public List<DoctosVentaDetalles> findDetallesByVentas(String dbName, List<Integer> doctosVeIds) {
        List<DoctosVentaDetalles> detalles = new ArrayList<>();
        if (doctosVeIds.size() == 0) {
            return detalles;
        }
        AgroalDataSource dataSource = datasourceService.getDataSource(dbName);
        String placeholders = doctosVeIds.stream().map(id -> "?")
                .collect(Collectors.joining(", "));
        var sql = "SELECT * FROM DOCTOS_VE_DET dvd WHERE dvd.DOCTO_VE_ID IN (" + placeholders + ")";

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            for (int i = 0; i < doctosVeIds.size(); i++) {
                stmt.setInt(i + 1, doctosVeIds.get(i));
            }
            try (ResultSet rs = stmt.executeQuery()) {
                Log.info(rs.toString());
                while (rs.next()) {
                    DoctosVentaDetalles detalle = new DoctosVentaDetalles();
                    detalle.doctoVeDetId = rs.getInt("DOCTO_VE_DET_ID");
                    detalle.doctoVeId = rs.getInt("DOCTO_VE_ID");
                    detalle.articuloId = rs.getInt("ARTICULO_ID");
                    detalle.unidades = rs.getBigDecimal("UNIDADES");
                    detalle.precioTotalNeto = rs.getBigDecimal("PRECIO_TOTAL_NETO");
                    detalles.add(detalle);
                }
                conn.close();
                return detalles;
            }

        } catch (Exception e) {
            Log.info(e);
            throw new RuntimeException(e);
        }
    }
//    public List<DoctosVentaDetalles> fondDetallesByDoctosVeIdsAndArticulo(List<Integer> doctosVeIds, Integer articuloId){
//        return list("doctoVeId in ?1 AND ARTICULO_ID = ?2", doctosVeIds, articuloId);
//    }
//
//    public  List<Integer> findDetallesIdsByDates(LocalDate inicio, LocalDate fin){
//        return getEntityManager().createQuery("SELECT dvd.doctoVeDetId FROM DoctosVentaDetalles dvd JOIN DoctosVenta dv ON dvd.doctoVeId = dv.doctoVeId WHERE dv.fecha BETWEEN :inicio AND :fin")
//                .setParameter("inicio", inicio)
//                .setParameter("fin", fin)
//                .getResultList();
//    }
//
//    public List<ArticuloTotal> findTotalesArticulos(LocalDate inicio, LocalDate fin) {
//        List<Object[]> result = getEntityManager()
//            .createQuery("""
//                SELECT (
//                    CASE
//                        WHEN A.nombre LIKE '%DIESEL%' THEN A.nombre
//                        WHEN A.nombre LIKE '%MAGNA%' THEN A.nombre
//                        WHEN A.nombre LIKE '%PEMEX PREMIUM%' THEN A.nombre
//                        ELSE 'ACEITES Y LUBRICANTES'
//                    END,
//                    CASE
//                        WHEN A.nombre LIKE '%DIESEL%' THEN A.id
//                        WHEN A.nombre LIKE '%MAGNA%' THEN A.id
//                        WHEN A.nombre LIKE '%PEMEX PREMIUM%' THEN A.id
//                        ELSE 0
//                    END,
//                    SUM(DVD.precioTotalNeto)
//                )
//                FROM DoctosVentaDetalles DVD
//                JOIN DoctosVenta DV ON DVD.doctoVeId = DV.doctoVeId
//                JOIN Articulo A ON DVD.articuloId = A.id
//                WHERE DV.fecha BETWEEN :inicio AND :fin
//                GROUP BY A.nombre, A.id
//            """)
//            .setParameter("inicio", inicio)
//            .setParameter("fin", fin)
//            .getResultList();
//
//        List<ArticuloTotal> resultParsed = new ArrayList<>();
//        for (Object[] row : result) {
//            ArticuloTotal articuloTotal = new ArticuloTotal();
//            articuloTotal.setArticulo((String) row[0]);
//            articuloTotal.setArticuloId((int) row[1]);
//            articuloTotal.setTotalneto((BigDecimal) row[2]);
//            resultParsed.add(articuloTotal);
//        }
//
//        return resultParsed;
//    }

}
