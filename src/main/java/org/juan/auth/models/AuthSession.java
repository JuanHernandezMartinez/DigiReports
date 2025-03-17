package org.juan.auth.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.UUID;

@Entity
@Table(name = "auth_session")
public class AuthSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "access_token", columnDefinition = "TEXT")
    public String accessToken;

    @Column(unique = true)
    public String username;

    @Column(name = "expires_at")
    public Time expiresAt;
}
