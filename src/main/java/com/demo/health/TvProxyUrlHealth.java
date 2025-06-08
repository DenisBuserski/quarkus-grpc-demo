package com.demo.health;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

@ApplicationScoped
public class TvProxyUrlHealth {

    @ConfigProperty(name = "com.demo.proxy.TvProxy/mp-rest/uri")
    String url;

    @Liveness
    HealthCheck url() {
        return new UrlHealthCheck(url).name("External URL API check");
    }
}
