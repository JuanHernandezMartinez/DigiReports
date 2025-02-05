package org.juan.ventas.services;

import java.time.LocalDate;
import java.util.List;

import org.juan.ventas.models.Articulo;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface VentasService {

    List<?> getVentas() throws Exception;

    List<Articulo> obtenerVentasArticulosPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

    List<?> obtenerVentasFormasPagoPorFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception;


}
