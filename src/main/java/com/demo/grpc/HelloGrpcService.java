package com.demo.grpc;

import com.demo.*;
import com.demo.model.Product;
import com.demo.service.ProductService;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Random;


@Slf4j
@GrpcService
public class HelloGrpcService implements HelloGrpc {
    @Inject
    ProductService productService;


    @Override
    public Uni<ProductResponse> insertProduct(ProductRequest request) {
        String name = request.getName();
        BigDecimal price = new BigDecimal(request.getPrice());
        int quantity = request.getQuantity();
        log.info("Inserting product with Name: [{}]; Price: [{}]; Quantity: [{}]", name, price, quantity);
        return Uni.createFrom()
                .item(() -> {
                    Product product = productService.insertProduct(name, price, quantity);
                    return product;
                })
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool()) // Moves to worker thread
                .onItem()
                .transform(product -> ProductResponse.newBuilder()
                        .setName(product.getName())
                        .setPrice(product.getPrice().toString())
                        .setQuantity(product.getQuantity())
                        .build()
                );
    }

    @Override
    public Uni<ProductResponse> getProductById(ProductIdRequest request) {
        return Uni.createFrom()
                .item(() -> productService.findProductById(request.getId()))
                .runSubscriptionOn(Infrastructure.getDefaultWorkerPool())
                .onItem()
                .transform(product -> {
                    if (product.isPresent()) {
                        return ProductResponse.newBuilder().setName("The product is " + product.get().getName()).build();
                    } else {
                        throw new RuntimeException("Product not found");
                    }
                });
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
