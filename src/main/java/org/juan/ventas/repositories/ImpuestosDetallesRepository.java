package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.juan.ventas.models.Impuesto;

@ApplicationScoped
public class ImpuestosDetallesRepository implements PanacheRepository<Impuesto> {

    public List<Impuesto> buscarImpuestosPorDetallesIds(List<Integer> detallesIds){
        return list("id in ?1", detallesIds);
    }
}
