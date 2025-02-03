package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import org.juan.ventas.dtos.ArticuloTotal;
import org.juan.ventas.models.DoctosVentaDetalles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DoctosVentaDetallesRepository implements PanacheRepository<DoctosVentaDetalles> {

    public List<DoctosVentaDetalles> findDetallesByVentas(List<Integer> doctosVeIds){
        return list("doctoVeId in ?1", doctosVeIds);
    }

    public List<DoctosVentaDetalles> fondDetallesByDoctosVeIdsAndArticulo(List<Integer> doctosVeIds, Integer articuloId){
        return list("doctoVeId in ?1 AND ARTICULO_ID = ?2", doctosVeIds, articuloId);
    }

    public  List<Integer> findDetallesIdsByDates(LocalDate inicio, LocalDate fin){
        return getEntityManager().createQuery("SELECT dvd.doctoVeDetId FROM DoctosVentaDetalles dvd JOIN DoctosVenta dv ON dvd.doctoVeId = dv.doctoVeId WHERE dv.fecha BETWEEN :inicio AND :fin")
                .setParameter("inicio", inicio)
                .setParameter("fin", fin)
                .getResultList();
    }

    public List<ArticuloTotal> findTotalesArticulos(LocalDate inicio, LocalDate fin) {
        List<Object[]> result = getEntityManager()
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

        List<ArticuloTotal> resultParsed = new ArrayList<>();
        for (Object[] row : result) {
            ArticuloTotal articuloTotal = new ArticuloTotal();
            articuloTotal.setArticulo((String) row[0]);
            articuloTotal.setArticuloId((int) row[1]);
            articuloTotal.setTotalneto((BigDecimal) row[2]);
            resultParsed.add(articuloTotal);
        }

        return resultParsed;
    }

}
