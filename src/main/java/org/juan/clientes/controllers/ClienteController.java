package org.juan.clientes.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juan.clientes.services.ClienteService;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Path("/clientes")
@RolesAllowed("Admin")
public class ClienteController {

    @Inject
    ClienteService service;

    @GET
    @Path("/saldos-clientes/{dbName}/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerSaldosDeClientesPorFechas(@PathParam("dbName") String dbName, @PathParam("startDate") LocalDate startDate, @PathParam("endDate") LocalDate endDate){
        try{
            return Response.ok(service.getSaldoClientesByFechas(dbName, startDate, endDate)).build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
