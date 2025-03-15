package org.juan.empresas.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.juan.empresas.services.EmpresaService;

@Path("/empresas")
public class EmpresasContorller {

    @Inject
    EmpresaService service;

    @GET
    @RolesAllowed("Admin")
    public Response consultarEmpresas() throws RuntimeException{
        return Response.ok(service.getBussines()).build();
    }
}
