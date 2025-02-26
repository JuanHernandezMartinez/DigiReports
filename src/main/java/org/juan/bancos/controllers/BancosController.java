package org.juan.bancos.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Param;
import org.juan.bancos.services.BancoService;
import java.time.LocalDate;

@Path("/bancos")
public class BancosController {

    @Inject
    private BancoService service;

    @GET
    @Path("/detalles/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detallesPorFechas(@Param() LocalDate startDate, @Param() LocalDate endDate) {
        try {
            return Response.ok(service.obtenerDetallesPorFechas(startDate, endDate)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
