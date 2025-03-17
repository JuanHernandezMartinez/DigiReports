package org.juan.auth.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.juan.auth.models.AuthSession;

import java.util.UUID;

@ApplicationScoped
public class AuthRepository implements PanacheRepositoryBase<AuthSession, UUID> {
}
