package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import org.juan.ventas.dtos.ArticuloTotal;
import org.juan.ventas.models.DoctosVentaDetalles;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DoctosVentaDetallesRepository implements PanacheRepository<DoctosVentaDetalles> {

    public List<DoctosVentaDetalles> findDetallesByDoctosVeIds(List<Integer> doctosVeIds){
        return list("doctoVeId in ?1", doctosVeIds);
    }

    public List<DoctosVentaDetalles> fondDetallesByDoctosVeIdsAndArticulo(List<Integer> doctosVeIds, Integer articuloId){
        return list("doctoVeId in ?1 AND ARTICULO_ID = ?2", doctosVeIds, articuloId);
    }

    public List<ArticuloTotal> findTotalesArticulos(LocalDate inicio, LocalDate fin) {
        return getEntityManager()
            .createQuery("""
                SELECT (
                    CASE
                        WHEN A.nombre LIKE '%DIESEL%' THEN A.nombre
                        WHEN A.nombre LIKE '%MAGNA%' THEN A.nombre
                        WHEN A.nombre LIKE '%PEMEX PREMIUM%' THEN A.nombre
                        ELSE 'ACEITES Y LUBRICANTES'
                    END,
                    CASE
                        WHEN A.nombre LIKE '%DIESEL%' THEN A.id
                        WHEN A.nombre LIKE '%MAGNA%' THEN A.id
                        WHEN A.nombre LIKE '%PEMEX PREMIUM%' THEN A.id
                        ELSE 0
                    END,
                    SUM(DVD.precioTotalNeto)
                )
                FROM DoctosVentaDetalles DVD
                JOIN DoctosVenta DV ON DVD.doctoVeId = DV.doctoVeId
                JOIN Articulo A ON DVD.articuloId = A.id
                WHERE DV.fecha BETWEEN :inicio AND :fin
                GROUP BY A.nombre, A.id
            """)
            .setParameter("inicio", inicio)
            .setParameter("fin", fin)
            .getResultList();
    }

    // public List<ArticuloTotal> findTotalesArticulos2(LocalDate inicio, LocalDate fin){
    //     Query query = entityManager.createNativeQuery("SELECT\n" + //
    //                     "    CASE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%DIESEL%' THEN A.NOMBRE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%MAGNA%' THEN A.NOMBRE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%PEMEX PREMIUM%' THEN A.NOMBRE\n" + //
    //                     "        ELSE 'ACEITES Y LUBRICANTES'\n" + //
    //                     "    END AS articulo,\n" + //
    //                     "    CASE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%DIESEL%' THEN A.ARTICULO_ID\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%MAGNA%' THEN A.ARTICULO_ID\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%PEMEX PREMIUM%' THEN A.ARTICULO_ID\n" + //
    //                     "        ELSE 0\n" + //
    //                     "    END AS articulo_id,\n" + //
    //                     "    SUM(DVD.PRECIO_TOTAL_NETO) AS totalneto\n" + //
    //                     "FROM DOCTOS_VE_DET DVD\n" + //
    //                     "JOIN DOCTOS_VE DV ON DVD.DOCTO_VE_ID = DV.DOCTO_VE_ID\n" + //
    //                     "JOIN ARTICULOS A ON DVD.ARTICULO_ID = A.ARTICULO_ID\n" + //
    //                     "WHERE DV.FECHA BETWEEN ? AND ?\n" + //
    //                     "GROUP BY \n" + //
    //                     "    CASE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%DIESEL%' THEN A.NOMBRE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%MAGNA%' THEN A.NOMBRE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%PEMEX PREMIUM%' THEN A.NOMBRE\n" + //
    //                     "        ELSE 'ACEITES Y LUBRICANTES'\n" + //
    //                     "    END,\n" + //
    //                     "    CASE\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%DIESEL%' THEN A.ARTICULO_ID\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%MAGNA%' THEN A.ARTICULO_ID\n" + //
    //                     "        WHEN A.NOMBRE LIKE '%PEMEX PREMIUM%' THEN A.ARTICULO_ID\n" + //
    //                     "        ELSE 0\n" + //
    //                     "    END");
    //                     query.setParameter(1, inicio);
    //                     query.setParameter(2, fin);

    //     return query.getResultList();
    // }
}
