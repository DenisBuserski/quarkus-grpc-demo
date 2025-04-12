package com.demo.service.impl;

import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import com.demo.service.ProductService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductRepository productRepository;


    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
