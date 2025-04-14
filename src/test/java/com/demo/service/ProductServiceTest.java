package com.demo.service;

import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.impl.ProductServiceImpl;
import io.quarkus.test.InjectMock;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@QuarkusTest
public class ProductServiceTest {
    @Inject
    ProductService productService;

    @InjectMock
    ProductRepository productRepository;

    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        mockProduct = Product.builder()
                .name("Apple")
                .price(new BigDecimal("19.99"))
                .quantity(10)
                .build();

        doNothing().when(productRepository).persist(any(Product.class));
        when(productRepository.findProductById(anyLong())).thenReturn(Optional.of(mockProduct));
    }


    @Test
    @DisplayName("Test insert product")
    @TestTransaction
    public void testInsertProduct() {
        mockProduct = productService.insertProduct("Apple", new BigDecimal("19.99"), 10);

        assertEquals("Apple", mockProduct.getName());
        assertEquals(new BigDecimal("19.99"), mockProduct.getPrice());
        assertEquals(10, mockProduct.getQuantity());

        verify(productRepository, times(1)).persist(mockProduct);
    }

    @Test
    @DisplayName("Test find product by id")
    void testFindProductById() {
        Optional<Product> foundProduct = productService.findProductById(mockProduct.getId());

        assertTrue(foundProduct.isPresent());
        assertEquals("Apple", foundProduct.get().getName());
    }
}
