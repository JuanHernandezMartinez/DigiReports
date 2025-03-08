package org.juan.auth.service.implementation;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claims;
import org.juan.auth.dtos.LoginRequest;
import org.juan.auth.service.AuthService;
import org.juan.datasource.UsersDatasourceService;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class AuthServiceImplementation implements AuthService {

    @Inject
    UsersDatasourceService datasourceService;

    @Override
    public String login(LoginRequest loginRequest) throws Exception {
        Log.info("Usuario: " + loginRequest.user + " Esta iniciando sesion");
        try {
            AgroalDataSource dataSource = datasourceService.getDataSource(loginRequest.user, loginRequest.password);

            if (loginRequest.user.equals("SYSDBA")) {
                throw new RuntimeException("Credenciales invalidas");
            }
            Connection conn = dataSource.getConnection();
            Log.info("Login correcto");
            return generateAccessToken();

        } catch (RuntimeException e) {
            Log.info("Error al iniciar sesion: " + e.getMessage());
            throw new RuntimeException("Credenciales invalidas");
        }
    }

    public String generateAccessToken() {
        return Jwt.issuer("https://sicws.com/issuer")
                .upn("sicws@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2003-08-04")
                .sign();
    }
}
