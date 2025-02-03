package org.juan.ventas.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.annotations.Param;
import org.juan.ventas.services.VentasService;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ventas")
public class VentasController {

    @Inject
    private VentasService ventasService;

    @GET
    @Path("/{inicio}/{fin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> obtenerVentasPorFechas(@Param() LocalDate inicio, @Param() LocalDate fin){
        try {
            Log.info("Buscando ventas en fecha inicio: " + inicio + ", fecha fin: " + fin);
            return ventasService.obtenerVentasPorFechas(inicio, fin);
        } catch (Exception e) {
            var error = new ArrayList<>();
            error.add(e.getMessage());
            return error;
        }
    }
    
}
