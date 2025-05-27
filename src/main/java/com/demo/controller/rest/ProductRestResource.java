package com.demo.controller.rest;

import com.demo.mapper.ProductMapper;
import com.demo.model.Product;
import com.demo.model.dto.ProductDTO;
import com.demo.model.dto.ProductRestRequest;
import com.demo.model.dto.ProductRestResponse;
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

@Path("/product")
@Tag(name = "ProductRestResource", description = "REST endpoint for products")
public class ProductRestResource {
    @Inject
    ProductService productService;

    @Inject
    ProductMapper productMapper;

    @POST
    @Path("/create")
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
                    description = "Product request",
                    content = @Content(schema = @Schema(implementation = Product.class)))
            ProductRestRequest productRESTRequest) {
        ProductDTO productDTO = mapProductRestRequestToProductDTO(productRESTRequest);
        Product product = productService.insertProduct(productDTO);
        // ProductRestResponse productRESTResponse = mapProductToProductRestResponse(product);
        ProductRestResponse productRESTResponse = productMapper.mapProductToProductRestResponse(product);
        return Response.status(Response.Status.CREATED).entity(productRESTResponse).build();
    }

    private ProductDTO mapProductRestRequestToProductDTO(ProductRestRequest productRESTRequest) {
        return ProductDTO.builder()
                .name(productRESTRequest.getName())
                .price(productRESTRequest.getPrice())
                .quantity(productRESTRequest.getQuantity())
                .build();
    }

    private ProductRestResponse mapProductToProductRestResponse(Product product) {
        return ProductRestResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            operationId = "getProduct",
            summary = "Get Product by id",
            description = "Get Product by id")
    @APIResponse(
            responseCode = "200",
            description = "Product found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @APIResponse(
            responseCode = "404",
            description = "No Product found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response getProduct(
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
