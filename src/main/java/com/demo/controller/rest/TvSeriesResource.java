package com.demo.controller.rest;

// import org.eclipse.microprofile.rest.client.inject.RestClient;


// @Path("/tvseries")
public class TvSeriesResource {

//    @RestClient
//    TvSerieProxy tvSerieProxy;

//    @ConfigProperty(name = "url")
//    URL serverURL;

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
