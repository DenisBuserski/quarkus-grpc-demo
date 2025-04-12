package com.demo.service.impl;

import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;


    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    @Transactional
    public Product insertProduct(String name, BigDecimal price, int quantity) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
        product.persist();
        return product;
    }
}
