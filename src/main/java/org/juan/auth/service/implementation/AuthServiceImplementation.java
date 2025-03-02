package org.juan.auth.service.implementation;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.jwt.Claims;
import org.juan.auth.dtos.LoginRequest;
import org.juan.auth.service.AuthService;

import java.util.Arrays;
import java.util.HashSet;

@Singleton
public class AuthServiceImplementation implements AuthService {

    @Override
    public String login(LoginRequest loginRequest) throws Exception {
        if(!loginRequest.user.equals("user") && !loginRequest.password.equals("password")){
            throw new Exception("Las credenciales son incorrectas");
        }
        return generateAccessToken();

    }

    public String generateAccessToken() {
        return Jwt.issuer("https://sicws.com/issuer")
                .upn("sicws@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2003-08-04")
                .sign();
    }
}
