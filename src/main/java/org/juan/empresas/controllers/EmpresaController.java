package org.juan.empresas.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.juan.empresas.services.EmpresaService;

@ApplicationScoped
@Path("/empresas")
@RolesAllowed("Admin")
public class EmpresaController {

    @Inject
    private EmpresaService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarEmpresas() {
        try {
            return Response.ok(service.getBussines()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener empresas").build();
        }
    }
}
