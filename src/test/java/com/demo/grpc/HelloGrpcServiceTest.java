package com.demo.grpc;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.*;
import com.demo.model.Product;
import com.demo.service.ProductService;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import io.smallrye.mutiny.Multi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
class HelloGrpcServiceTest {
    @GrpcClient
    HelloGrpc helloGrpc;

    @InjectMock
    ProductService productService;

    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        mockProduct = Product.builder()
                .name("Apple")
                .price(new BigDecimal("19.99"))
                .quantity(10)
                .build();

        when(productService.insertProduct(anyString(), any(), anyInt())).thenReturn(mockProduct);
    }


    @Test
    @DisplayName("Test insert product")
    public void testInsertProduct() {
        ProductRequest request = ProductRequest.newBuilder()
                .setName("Apple")
                .setPrice("19.99")
                .setQuantity(10)
                .build();

        ProductResponse response = helloGrpc.insertProduct(request).await().indefinitely();

        assertEquals("Apple", response.getName());
        assertEquals("19.99", response.getPrice());
        assertEquals(10, response.getQuantity());
    }

    @Test
    public void testHello() {
        HelloReply reply = helloGrpc.sayHello(HelloRequest.newBuilder().setName("Neo").build())
                .await()
                .atMost(Duration.ofSeconds(5));
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
