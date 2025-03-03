package org.juan.ventas.services;

import java.time.LocalDate;
import java.util.List;

import org.juan.ventas.models.Articulo;

import jakarta.enterprise.context.ApplicationScoped;


public interface VentasService {

    List<Articulo> obtenerVentasArticulosPorFechas(String dbName, LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

}
