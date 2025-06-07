package com.demo.health;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.util.Optional;

@Readiness
public class TvProxyCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        Optional<String> defaultValue = ConfigProvider.getConfig().getOptionalValue("default.title", String.class);
        if (defaultValue.isPresent()) {
            return HealthCheckResponse.named("External API is UP").up().build();
        }
        return HealthCheckResponse.named("Internal API is DOWN").down().build();
    }
}
