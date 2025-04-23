package com.demo.controller.rest;

// import org.eclipse.microprofile.rest.client.inject.RestClient;


import com.demo.model.TvRESTResponse;
import com.demo.proxy.TvProxy;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
// import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// @Path("/api/tv")
public class TvResource {

//    @RestClient
//    TvProxy tvProxy;

//    @ConfigProperty(name = "url")
//    URL serverURL;

    List<TvRESTResponse> tvSeries = new ArrayList<>();

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Timeout(2000)
//    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 8000, successThreshold = 2)
//    @Retry(maxRetries = 4)
//    @Fallback(fallbackMethod = "fallbackGet")
//    public Response getTvSeries(@QueryParam("title") String title) {
//        TvRESTResponse tvRESTResponse = tvProxy.get(title);
//        tvSeries.add(tvRESTResponse);
//        return Response.ok(tvSeries).build();
//    }

//    private Response fallbackGet(String title) {
//        return Response.ok(new ArrayList<>()).build();
//    }
}
