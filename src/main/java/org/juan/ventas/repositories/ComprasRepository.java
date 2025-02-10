package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.juan.ventas.models.Compra;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ComprasRepository implements PanacheRepository<Compra> {

    List<Compra> findByFechas(LocalDate inicio, LocalDate fin){
        return list("fecha BETWEEN :inicio AND :fin",inicio,fin);
    }
}
