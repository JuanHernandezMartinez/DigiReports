package org.juan.bancos.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.annotations.Param;
import org.juan.bancos.models.DetalleBanco;
import org.juan.bancos.services.BancoService;
import java.time.LocalDate;
import java.util.List;

@Path("/bancos")
public class BancosController {

    @Inject
    private BancoService service;

    @GET
    @Path("/detalles/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleBanco> detallesPorFechas(@Param() LocalDate startDate, @Param() LocalDate endDate){
        return service.obtenerDetallesPorFechas(startDate, endDate);
    }

}
