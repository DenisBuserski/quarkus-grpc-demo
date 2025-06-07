package com.demo.controller.rest;

import com.demo.ProductRequest;
import com.demo.dto.ProductRestRequest;
import com.demo.mapper.ProductMapper;
import com.demo.model.Product;
import com.demo.service.ProductService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.wildfly.common.Assert.assertNotNull;


// @QuarkusTest
public class ProductRestResourceTest {
    @Inject
    ProductRestResource productRestResource;

    @InjectMock
    ProductService productService;

    @InjectMock
    ProductMapper productMapper;

    Product mockProduct;

    @BeforeEach
    void setUp() {
        mockProduct = Product.builder()
                .name("Apple")
                .price(new BigDecimal("19.99"))
                .quantity(10)
                .build();
    }

    @Test
    @DisplayName("Test create product")
    public void testCreateProduct() {
        doNothing().when(productRestResource).createProduct(any(ProductRestRequest.class));
    }

    @Test
    @DisplayName("Test get the product by id")
    public void testGetProductById() {
        when(productService.findProductById(anyLong())).thenReturn(Optional.ofNullable(mockProduct));

        Response response = productRestResource.getProduct(anyLong());

        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());
    }

}
