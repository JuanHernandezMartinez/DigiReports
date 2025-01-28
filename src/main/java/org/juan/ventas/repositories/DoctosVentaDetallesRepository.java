package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.juan.ventas.models.DoctosVentaDetalles;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class DoctosVentaDetallesRepository implements PanacheRepository<DoctosVentaDetalles> {

    public List<DoctosVentaDetalles> fondDetallesByDoctosVeIds(List<Integer> doctosVeIds){
        return list("DOCTO_VE_ID in ?1", doctosVeIds);
    }

    public List<DoctosVentaDetalles> fondDetallesByDoctosVeIdsAndArticulo(List<Integer> doctosVeIds, Integer articuloId){
        return list("DOCTO_VE_ID in ?1 AND ARTICULO_ID = ?2", doctosVeIds, articuloId);
    }
}
