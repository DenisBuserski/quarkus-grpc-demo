package com.demo;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public interface HelloGrpc extends MutinyService {

    io.smallrye.mutiny.Uni<com.demo.HelloReply> sayHello(com.demo.HelloRequest request);

    io.smallrye.mutiny.Uni<com.demo.ProductResponse> getProductById(com.demo.ProductIdRequest request);

    io.smallrye.mutiny.Uni<com.demo.ProductResponse> insertProduct(com.demo.ProductRequest request);

    io.smallrye.mutiny.Multi<com.demo.NumberResponse> streamRandomNumbers(com.demo.NumberRequest request);
}
