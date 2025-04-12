package com.demo.service;


import com.demo.model.Product;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findProductById(Long id);

    Product insertProduct(String name, BigDecimal price, int quantity);
}
