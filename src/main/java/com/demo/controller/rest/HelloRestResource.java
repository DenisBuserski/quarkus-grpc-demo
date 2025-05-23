package com.demo.controller.rest;

import com.demo.service.HelloRestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/hello")
@Tag(name = "HelloRestResource", description = "REST endpoint for test")
public class HelloRestResource {
    @Inject
    HelloRestService helloRestService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            operationId = "helloID",
            summary = "Say Hello",
            description = "Simple method that prints Hello")
    @APIResponse(
            responseCode = "200",
            description = "Operation completed",
            content = @Content(mediaType = MediaType.TEXT_PLAIN))
    public Response hello() {
        return Response.ok(helloRestService.hello()).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return helloRestService.greeting(name);
    }


}
