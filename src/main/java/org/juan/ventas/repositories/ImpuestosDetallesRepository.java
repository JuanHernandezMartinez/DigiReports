package org.juan.ventas.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.juan.ventas.models.Impuesto;

@ApplicationScoped
public class ImpuestosDetallesRepository {

    @Inject
    EntityManager entityManager;

    public List<Impuesto> findImpuestosByDetallesIds(List<Integer> detallesIds){
        String sql = "SELECT IMPUESTO_ID, DOCTO_VE_DET_ID, IMPORTE_IMPUESTO_BRUTO FROM IMPUESTOS_DOCTOS_VE_DET WHERE DOCTO_VE_DET_ID in :ids";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("ids", detallesIds);
        List<Object[]> resultados = query.getResultList();
        List<Impuesto> impuestos = new ArrayList<>();

        for(Object[] r:resultados){
            Impuesto impuesto = new Impuesto();
            impuesto.setId((Integer) r[0]);
            impuesto.setDetalleId((Integer) r[1]);
            impuesto.setImporteImpuesto((BigDecimal) r[2]);
            impuestos.add(impuesto);

        }
        return impuestos;
    }
}
