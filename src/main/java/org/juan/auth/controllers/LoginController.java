package org.juan.auth.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.juan.auth.dtos.LoginRequest;
import org.juan.auth.service.AuthService;

@Path("/auth")
public class LoginController {

    @Inject
    AuthService service;

    @POST
    @Path("/login")
    public Response loginHandler(LoginRequest loginRequest) {
        try {
            return Response.ok(service.login(loginRequest)).build();
        } catch (Exception e) {
            return Response.status(401).entity("Credenciales invalidas").build();
        }
    }

}
