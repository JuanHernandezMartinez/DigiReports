package org.juan.ventas.controllers;

import java.time.LocalDate;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.juan.ventas.services.VentasService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/ventas")
@RolesAllowed("Admin")
public class VentasController {

    @Inject
    VentasService service;

    @GET
    @Path("/articulos/{dataBase}/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerVentasDeArticulosPorFechas(@PathParam("dataBase") String dbName, @PathParam("startDate") LocalDate inicio, @PathParam("endDate") LocalDate fin) {
        Log.info("Buscando ventas en fecha inicio: " + inicio + ", fecha fin: " + fin);
        try {
            return Response.ok(service.obtenerVentasArticulosPorFechas(dbName, inicio, fin)).build();
        } catch (Exception error) {
            return Response.status(400, error.getMessage()).build();
        }
    }
}
