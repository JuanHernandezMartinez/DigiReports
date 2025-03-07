package org.juan.auth.controllers;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.juan.auth.dtos.LoginRequest;
import org.juan.auth.service.AuthService;

@Path("/login")
public class LoginController {

    @Inject
    AuthService service;

    @POST
    public Response loginHandler(LoginRequest loginRequest){
        try {
            return Response.ok(service.login(loginRequest)).build();
        } catch (Exception e) {
            Log.info(e.getMessage());
            return Response.status(401).entity(e.getMessage()).build();
        }
    }

}
