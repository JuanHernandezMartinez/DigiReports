package org.juan.ventas.services;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface VentasService {

    List<?> getVentas() throws Exception;

    List<?> obtenerVentasPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

}
