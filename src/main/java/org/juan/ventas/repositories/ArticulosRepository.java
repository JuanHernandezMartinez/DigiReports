package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import org.juan.ventas.models.Articulo;
import java.util.List;

@ApplicationScoped
public class ArticulosRepository implements PanacheRepository<Articulo> {

    @Inject
    private EntityManager entityManager;

    public List<Articulo> findArticlesByDetalles(List<Integer> articulosIds){
        return list("id in ?1", articulosIds);
    }

    public List<Articulo> findArticlesByIds(List<Integer> articulosIds){
        return list("id in ?1", articulosIds);
    }

    public Articulo findArticuloByName(String name){
        return find("nombre", name).firstResult();
    }
}
