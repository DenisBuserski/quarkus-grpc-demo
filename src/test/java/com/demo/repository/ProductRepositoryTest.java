package com.demo.repository;

import com.demo.model.Product;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static io.smallrye.common.constraint.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ProductRepositoryTest {

    @Inject
    ProductRepository productRepository;

    @Test
    @DisplayName("Test find product by id")
    @TestTransaction
    void testFindProductById() {
        Product product = Product.builder()
                .name("Test product name")
                .price(new BigDecimal("99.99"))
                .quantity(100)
                .build();
        productRepository.persist(product);

        Optional<Product> productById = productRepository.findProductById(product.getId());

        // Verify: Check that the retrieved product matches the original
        assertTrue(productById.isPresent());
        assertEquals("Test product name", productById.get().getName());
    }
}
