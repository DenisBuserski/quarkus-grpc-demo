package com.demo.security;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.Set;

@Singleton
public class SecurityJwtService {
    private static final Set<String> ROLES = Set.of("admin", "jwt-user");

    public String generateJwt() {
        return Jwt.issuer("demo-application-jwt")
                .subject("demo-application-jwt")
                .groups(ROLES)
                .expiresAt(System.currentTimeMillis() + 3600)
                .sign();
    }
}
