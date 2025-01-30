package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.juan.ventas.models.Articulo;
import org.juan.ventas.models.DoctosVentaDetalles;

import java.util.List;

public class ArticulosRepository implements PanacheRepository<Articulo> {

//    public List<DoctosVentaDetalles> findDetallesByDoctosVeIds(List<Integer> doctosVeIds){
//        return list("DOCTO_VE_ID in ?1", doctosVeIds);
//    }
}
