package com.demo.controller.grpc;

import com.demo.*;
import com.demo.model.Product;
import com.demo.dto.ProductDTO;
import com.demo.service.ProductService;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;
import java.util.Random;


@Slf4j
@GrpcService
public class HelloGrpcService implements HelloGrpc {
    @Inject
    ProductService productService;

    @Override
    public Uni<ProductResponse> insertProduct(ProductRequest productRequest) {
        ProductDTO productDTO = mapProductRequestToProductDTO(productRequest);
        return Uni.createFrom()
                .item(() -> productService.insertProduct(productDTO))
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool())
                .onItem()
                .transform(this::mapProductToProductResponse);
    }

    private ProductDTO mapProductRequestToProductDTO(ProductRequest productRequest) {
        return ProductDTO.builder()
                .name(productRequest.getName())
                .price(new BigDecimal(productRequest.getPrice()))
                .quantity(productRequest.getQuantity())
                .build();
    }

    private ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.newBuilder()
                .setName(product.getName())
                .setPrice(product.getPrice().toString())
                .setQuantity(product.getQuantity())
                .build();
    }

    @Override
    public Uni<ProductResponse> getProductById(ProductIdRequest request) {
        long productId = request.getId();
        return Uni.createFrom()
                .item(() -> productService.findProductById(productId))
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool())
                .onItem()
                .transform(this::mapOptionalProductToProductResponse);
    }

    private ProductResponse mapOptionalProductToProductResponse(Optional<Product> product) {
        return product.map(this::mapProductToProductResponse)
                .orElseGet(() -> ProductResponse.newBuilder().build());
    }


    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom()
                .item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }


    @Override
    public Multi<NumberResponse> streamRandomNumbers(NumberRequest request) {
        Random random = new Random();
        return Multi.createFrom()
                .ticks()
                .every(Duration.ofSeconds(5))
                .select()
                .first(request.getCount())
                .map(tick -> NumberResponse.newBuilder()
                        .setIndex(tick + 1)
                        .setValue(random.nextInt(100))
                        .build());
    }

}
