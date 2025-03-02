package org.juan.security.jwt;

import java.util.Arrays;
import java.util.HashSet;
import org.eclipse.microprofile.jwt.Claims;
import io.smallrye.jwt.build.Jwt;

/**
 * A utility class to generate and print a JWT token string to stdout.
 */
public class GenerateToken {

    /**
     * Generates and prints a JWT token.
     */
    public static void main(String[] args) {
        String token = Jwt.issuer("https://sicws.com/issuer")
                .upn("sicws@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2003-08-04")
                .sign();

        System.out.println(token);
        System.exit(0);
    }
}