package com.demo.service;

import com.demo.model.Product;
import com.demo.dto.ProductDTO;
import com.demo.repository.ProductRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.TestTransaction;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @InjectMock
    ProductService productService;

    private ProductDTO mockProductDTO;
    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        mockProductDTO = ProductDTO.builder()
                .name("Apple")
                .price(new BigDecimal("19.99"))
                .quantity(10)
                .build();

        mockProduct = Product.builder()
                .name("Apple")
                .price(new BigDecimal("19.99"))
                .quantity(10)
                .build();
    }


    @Test
    @DisplayName("Test insert product")
    @TestTransaction
    // @Transactional annotation on tests, means that the changes your test makes to the database will be persistent. If
    // you want any changes made to be rolled back at the end of the test you can use the @TestTransaction. This will
    // run the test method in a transaction, but roll it back once the test method is complete to revert any database changes.
    public void testInsertProduct() {
        doNothing().when(productRepository).persist(any(Product.class));

        Product mockProduct = productService.insertProduct(mockProductDTO);

        assertEquals("Apple", mockProduct.getName());
        assertEquals(new BigDecimal("19.99"), mockProduct.getPrice());
        assertEquals(10, mockProduct.getQuantity());

        verify(productRepository, times(1)).persist(any(Product.class));
    }

    @Test
    @DisplayName("Test find product by id when there is a product")
    void testFindProductById() {
        when(productRepository.findProductById(1L)).thenReturn(Optional.of(mockProduct));

        Optional<Product> foundProduct = productService.findProductById(1L);

        assertTrue(foundProduct.isPresent());
        assertEquals("Apple", foundProduct.get().getName());

        verify(productRepository).findProductById(1L);
    }

    @Test
    @DisplayName("Test find product by id when there is no product")
    void testFindProductByIdNotFound() {
        when(productRepository.findProductById(99L)).thenReturn(Optional.empty());

        Optional<Product> foundProduct = productService.findProductById(99L);

        assertFalse(foundProduct.isPresent());

        verify(productRepository).findProductById(99L);
    }
}
