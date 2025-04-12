package com.demo.grpc;

import com.demo.*;
import com.demo.model.Product;
import com.demo.service.ProductService;
import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

import java.time.Duration;
import java.util.Optional;
import java.util.Random;


@GrpcService
public class HelloGrpcService implements HelloGrpc {
    @Inject
    private ProductService productService;

    @Override
    public Uni<ProductResponse> getProductById(ProductIdRequest request) {
        Optional<Product> product = productService.findProductById(request.getId());
        if (product.isPresent()) {
            String name = product.get().getName();
            Uni.createFrom()
                    .item("The product is " + name)
                    .map(message -> ProductResponse.newBuilder().setName(message).build());
        }
        return Uni.createFrom().failure(new Throwable("Product not found"));
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
