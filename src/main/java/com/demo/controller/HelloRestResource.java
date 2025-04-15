package com.demo.controller;

import com.demo.service.HelloRestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloRestResource {
    @Inject
    HelloRestService helloRestService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return helloRestService.hello();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return "Hello " + name;
    }

}
