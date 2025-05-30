package com.demo.proxy;

import com.demo.dto.TvRestResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient // Move 'baseUri' to application.properties
// @RegisterRestClient(baseUri = "https://api.tvmaze.com")
@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
public interface TvProxy {
    // https://api.tvmaze.com/singlesearch/shows?q=game

    @GET
    @Path("/shows")
    TvRestResponse get(@QueryParam("q") String title);
}
