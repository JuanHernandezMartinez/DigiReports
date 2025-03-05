package org.juan.ventas.controllers;

import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juan.ventas.services.TotalFormaPagoService;

import java.time.LocalDate;

@RequestScoped
@Path("/formas-pago")
@RolesAllowed("Admin")
public class TotalFormaPagoController {

    @Inject
    TotalFormaPagoService service;

    @GET
    @Path("/fechas/{dbName}/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTotalesPorFormaDePagoController(@PathParam("dbName") String dbName,@PathParam("startDate") LocalDate startDate, @PathParam("endDate") LocalDate endDate){
        Log.info("Buscando totales forma de pago en fecha inicio: " + startDate + ", fecha fin: " + endDate);
        try {
            return Response.ok(service.totalPorFormaDePagoYFechas(dbName, startDate, endDate)).build();
        } catch (Exception error) {
            return Response.status(400, error.getMessage()).build();
        }
    }

}
