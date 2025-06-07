package com.demo.health;

import com.demo.proxy.TvProxy;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Liveness
public class TvProxyHealth implements HealthCheck {

    @RestClient
    TvProxy tvProxy;

    @Override
    public HealthCheckResponse call() {
        tvProxy.get("title");
        return HealthCheckResponse.named("External API is up").up().build();
    }
}
