package org.juan.bancos.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juan.bancos.services.BancoService;
import java.time.LocalDate;

@ApplicationScoped
@Path("/bancos")
@RolesAllowed("Admin")
public class BancosController {

    @Inject
    BancoService service;

    @GET
    @Path("/detalles/{dbName}/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detallesDeBancosPorFechas(@PathParam("dbName") String dbName, @PathParam("startDate") LocalDate startDate, @PathParam("endDate") LocalDate endDate) {
        try {
            return Response.ok(service.obtenerDetallesPorFechas(dbName, startDate, endDate)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
