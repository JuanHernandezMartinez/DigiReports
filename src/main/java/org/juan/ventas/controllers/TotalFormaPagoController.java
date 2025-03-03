package org.juan.ventas.controllers;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juan.ventas.services.TotalFormaPagoService;

import java.time.LocalDate;

@Path("/formas-pago")
public class TotalFormaPagoController {

    @Inject
    private TotalFormaPagoService service;

    @GET
    @Path("/fechas/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTotalesPorFormaDePagoController(@PathParam("startDate") LocalDate inicio, @PathParam("endDate") LocalDate fin){
        Log.info("Buscando totales forma de pago en fecha inicio: " + inicio + ", fecha fin: " + fin);
        try {
            return Response.ok(service.TotalPorFormaDePagoYFechas(inicio, fin)).build();
        } catch (Exception error) {
            return Response.status(400, error.getMessage()).build();
        }
    }

}
