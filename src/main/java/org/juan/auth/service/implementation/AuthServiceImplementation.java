package org.juan.auth.service.implementation;

import io.agroal.api.AgroalDataSource;
import io.quarkus.logging.Log;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.jwt.Claims;
import org.juan.auth.dtos.LoginRequest;
import org.juan.auth.models.AuthSession;
import org.juan.auth.repositories.AuthRepository;
import org.juan.auth.service.AuthService;
import org.juan.datasource.UsersDatasourceService;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class AuthServiceImplementation implements AuthService {

    @Inject
    UsersDatasourceService datasourceService;

    @Inject
    AuthRepository repository;

    @Override
    @Transactional
    public String login(LoginRequest loginRequest) throws Exception {
        Log.info("Usuario: " + loginRequest.user + " Esta iniciando sesion");
        try {
            AgroalDataSource dataSource = datasourceService.getDataSource(loginRequest.user, loginRequest.password);

            if (loginRequest.user.equals("SYSDBA")) {
                throw new RuntimeException("Credenciales invalidas");
            }
            try(Connection conn = dataSource.getConnection()){
                Log.info("Login correcto");
                AuthSession session = new AuthSession();
                session.username = loginRequest.user;
                session.accessToken = generateAccessToken(loginRequest.user);
                session.expiresAt  = Time.valueOf(LocalTime.now().plusSeconds(900));
                repository.persist(session);
                return session.accessToken;
            }
        } catch (Exception e) {
            Log.info("Error al iniciar sesion: " + e.getMessage());
            throw new RuntimeException("Credenciales invalidas");
        }
    }

    private String generateAccessToken(String username) {
        return Jwt.issuer("https://sicws.com/issuer")
                .upn("sicws@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .preferredUserName(username)
                .claim(Claims.birthdate.name(), "2003-08-04")
                .expiresAt(900)
                .sign();
    }
}
