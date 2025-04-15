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
        
        when(productRepository.findProductById(1L)).thenReturn(Optional.of(mockProduct));
        when(productRepository.findProductById(99L)).thenReturn(Optional.empty());
    }


    @Test
    @DisplayName("Test insert product")
    @TestTransaction
    // @Transactional annotation on tests, means that the changes your test makes to the database will be persistent. If
    // you want any changes made to be rolled back at the end of the test you can use the @TestTransaction. This will
    // run the test method in a transaction, but roll it back once the test method is complete to revert any database changes.
    public void testInsertProduct() {
        doNothing().when(productRepository).persist(any(Product.class));
        mockProduct = productService.insertProduct("Apple", new BigDecimal("19.99"), 10);

        assertEquals("Apple", mockProduct.getName());
        assertEquals(new BigDecimal("19.99"), mockProduct.getPrice());
        assertEquals(10, mockProduct.getQuantity());

        verify(productRepository, times(1)).persist(any(Product.class));
    }

    @Test
    @DisplayName("Test find product by id when there is a product")
    void testFindProductById() {
        Optional<Product> foundProduct = productService.findProductById(1L);

        assertTrue(foundProduct.isPresent());
        assertEquals("Apple", foundProduct.get().getName());

        verify(productRepository).findProductById(1L);
    }

    @Test
    @DisplayName("Test find product by id when there is no product")
    void testFindProductByIdNotFound() {
        Optional<Product> foundProduct = productService.findProductById(99L);

        assertFalse(foundProduct.isPresent());

        verify(productRepository).findProductById(99L);
    }
}
