package org.juan.ventas.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.juan.ventas.models.ImpuestoDoctoVentasDetalles;

@ApplicationScoped
public class ImpuestosDoctosVentasDetallesRepository implements PanacheRepository<ImpuestoDoctoVentasDetalles> {
}
