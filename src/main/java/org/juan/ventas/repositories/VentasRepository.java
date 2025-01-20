package org.juan.ventas.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.juan.ventas.models.DoctosVe;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VentasRepository implements PanacheRepository<DoctosVe>  {

    public List<DoctosVe> finDoctosVes(){
        return listAll();
    }

    public List<DoctosVe> finDoctosVesByDates(LocalDateTime inicio, LocalDateTime fin){
        return list("fechaHoraCreacion BETWEEN ?1 AND ?2", inicio, fin);
    }
    
}
