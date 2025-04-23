package com.demo.service;

import com.demo.model.Product;
import com.demo.model.dto.ProductDTO;
import com.demo.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Transactional
    public Product insertProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        productRepository.persist(product);
        return product;
    }
}
