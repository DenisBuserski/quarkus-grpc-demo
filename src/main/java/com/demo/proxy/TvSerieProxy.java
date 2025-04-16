package com.demo.proxy;

import com.demo.model.TvSerie;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
// import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


//@RegisterRestClient
//@RegisterRestClient(baseUri = "https://www.tvmaze.com/api")
//@Path("/singlesearch")
//@Produces(MediaType.APPLICATION_JSON)
public interface TvSerieProxy {
    // https://www.tvmaze.com/api
    // https://api.tvmaze.com/singlesearch/shows?q=game

//    @GET
//    @Path("/shows")
//    TvSerie get(@QueryParam("q") String title);

}
