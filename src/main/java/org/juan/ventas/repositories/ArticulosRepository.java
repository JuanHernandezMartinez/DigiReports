package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.juan.ventas.models.Articulo;
import java.util.List;

@ApplicationScoped
public class ArticulosRepository implements PanacheRepository<Articulo> {

    public List<Articulo> findArticlesByIds(List<Integer> articulosIds){
        return list("id in ?1", articulosIds);
    }
}
