package org.juan.ventas.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.annotations.Param;
import org.juan.ventas.services.VentasService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ventas")
public class VentasResource {

    @Inject
    private VentasService ventasService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> getSoldsHandler(){
        try {
            return ventasService.getVentas();
        } catch (Exception e) {
            var error = new ArrayList<>();
            error.add(e.getMessage());
            return error;
        }
    }

    @GET
    @Path("/{inicio}/{fin}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> getSoldsByDatesHandler(@Param() LocalDate inicio, @Param() LocalDate fin){
        try {
            System.out.println("Fecha inicio: " + inicio + " Fecha fin: " + fin);
            return ventasService.getSoldsByDates(inicio, fin);
        } catch (Exception e) {
            var error = new ArrayList<>();
            error.add(e.getMessage());
            return error;
        }
    }
    
}
