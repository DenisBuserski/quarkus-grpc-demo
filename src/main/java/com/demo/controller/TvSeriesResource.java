package com.demo.controller;

import com.demo.model.TvSerie;
import com.demo.proxy.TvSerieProxy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
// import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

// @Path("/tvseries")
public class TvSeriesResource {

//    @RestClient
//    TvSerieProxy tvSerieProxy;

//    List<TvSerie> tvSeries = new ArrayList<>();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Timeout(2000)
//    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 8000, successThreshold = 2)
//    @Retry(maxRetries = 4)
//    @Fallback(fallbackMethod = "fallbackGet")
//    public Response getTvSeries(@QueryParam("title") String title) {
//        TvSerie tvSerie = tvSerieProxy.get(title);
//        tvSeries.add(tvSerie);
//        return Response.ok(tvSeries).build();
//    }

//    private Response fallbackGet(String title) {
//        return Response.ok(new ArrayList<>()).build();
//    }
}
