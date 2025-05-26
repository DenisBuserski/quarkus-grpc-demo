package com.demo.controller.rest;

import com.demo.model.dto.TvRestResponse;
import com.demo.proxy.TvProxy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Path("/api/tv")
@Slf4j
public class TvRestResource {

    @RestClient // Automatically includes @Inject behavior
    TvProxy tvProxy;

    @ConfigProperty(name = "tv.proxy.url")
    URL serverURL;

    List<TvRestResponse> tvSeries = new ArrayList<>();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @Timeout(2000) // How much time to wait
    @CircuitBreaker(
            // If this method keeps failing too often, stop calling it for a while
            // Stops repeated failures to protect the system
            requestVolumeThreshold = 4, // Starts evaluating after 4 calls
            failureRatio = 0.5, // If 50% or more of those 4 calls fail, it opens the circuit
            delay = 8000, // The circuit stays open for 8 seconds(During this time, no real calls go through)
            successThreshold = 2) // After the delay, it allows some trial calls — If 2 in a row succeed, it closes the circuit again
    @Retry(maxRetries = 4) // Retry up to 4 times(Total of 5 attempts: 1 original + 4 retries)
    @Fallback(fallbackMethod = "fallbackGet")
    public Response getTvSeries(@QueryParam("title") String title) {
        log.info("Connecting to [{}]", serverURL);
        TvRestResponse tvRESTResponse = tvProxy.get(title);
        tvSeries.add(tvRESTResponse);
        return Response.ok(tvSeries).build();
    }

    private Response fallbackGet(String title) {
        return Response.ok(new ArrayList<>()).build();
    }

}
