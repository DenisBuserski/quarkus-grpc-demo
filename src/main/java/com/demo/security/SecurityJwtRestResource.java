package com.demo.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

@Path("/security/jwt")
@SecurityScheme(
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT"
)
@ApplicationScoped
public class SecurityJwtRestResource {
    @Inject
    SecurityJwtService securityJwtService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/generate")
    public Response getJwt() {
        String jwt = securityJwtService.generateJwt();
        return Response.ok(jwt).build();
    }
}
