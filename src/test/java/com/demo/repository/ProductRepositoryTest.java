package com.demo.repository;

import com.demo.model.Product;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ProductRepositoryTest {

    @Inject
    ProductRepository productRepository;

    @Test
    @DisplayName("Test find product by id when there is a product")
    @TestTransaction
    void testFindProductById() {
        Product product = Product.builder()
                .name("Test product name")
                .price(new BigDecimal("99.99"))
                .quantity(100)
                .build();
        productRepository.persist(product);

        Optional<Product> productById = productRepository.findProductById(product.getId());

        assertTrue(productById.isPresent());
        assertEquals("Test product name", productById.get().getName());
    }

}
