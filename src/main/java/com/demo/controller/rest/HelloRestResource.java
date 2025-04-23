package com.demo.controller.rest;

import com.demo.model.Product;
import com.demo.model.dto.ProductDTO;
import com.demo.model.dto.ProductRESTRequest;
import com.demo.model.dto.ProductRESTResponse;
import com.demo.service.HelloRestService;
import com.demo.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Optional;

@Path("/hello")
@Tag(name = "HelloRestResource", description = "REST endpoint for test")
public class HelloRestResource {
    @Inject
    HelloRestService helloRestService;

    @Inject
    ProductService productService;

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

    @POST
    @Path("/create/product")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "createProduct",
        summary = "Create new Product",
        description = "Create new Product and add it in the DB")
    @APIResponse(
        responseCode = "201",
        description = "Product created",
        content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response createProduct(
        @RequestBody(
            description = "Person to create",
            content = @Content(schema = @Schema(implementation = Product.class)))
        ProductRESTRequest productRESTRequest) {

        ProductDTO productDTO = mapProductRequestToProductDTO(productRESTRequest);
        Product product = productService.insertProduct(productDTO);
        ProductRESTResponse productRESTResponse = mapProductToProductResponse(product);
        return Response.status(Response.Status.CREATED).entity(productRESTResponse).build();
    }

    private ProductDTO mapProductRequestToProductDTO(ProductRESTRequest productRESTRequest) {
        return ProductDTO.builder()
                .name(productRESTRequest.getName())
                .price(productRESTRequest.getPrice())
                .quantity(productRESTRequest.getQuantity())
                .build();
    }

    private ProductRESTResponse mapProductToProductResponse(Product product) {
        return ProductRESTResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "200",
            description = "Product found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(
            responseCode = "404",
            description = "No product found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response getProducts(
            @Parameter(
                    description = "Product id",
                    required = true)
            @PathParam("id") long id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) {
            return Response.ok(product.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
