package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import io.smallrye.mutiny.Multi;
import org.junit.jupiter.api.Test;

@QuarkusTest
class HelloGrpcServiceTest {
    @GrpcClient
    HelloGrpc helloGrpc;

    @Test
    public void testHello() {
        HelloReply reply = helloGrpc
                .sayHello(HelloRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
        assertEquals("Hello Neo!", reply.getMessage());
    }

    @Test
    public void testNumberStream() {
        Multi<NumberResponse> responses = helloGrpc.streamRandomNumbers(NumberRequest.newBuilder().setCount(2).build());
        List<Long> values = responses.map(response -> response.getValue()).subscribe().asStream().collect(Collectors.toList());
        assertEquals(2, values.size());
        assertTrue(values.get(0) <= 100);
        assertTrue(values.get(0) >= 0);
        assertTrue(values.get(1) <= 100);
        assertTrue(values.get(1) >= 0);

    }

}
