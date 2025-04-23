package com.demo.proxy;

import com.demo.model.TvRESTResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
// import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


//@RegisterRestClient(baseUri = "https://api.tvmaze.com")
////@RegisterRestClient
//@Path("/singlesearch")
//@Produces(MediaType.APPLICATION_JSON)
public interface TvProxy {
    // https://www.tvmaze.com/api
    // https://api.tvmaze.com/singlesearch/shows?q=game

//    @GET
//    @Path("/shows")
//    TvRESTResponse get(@QueryParam("q") String title);

}
