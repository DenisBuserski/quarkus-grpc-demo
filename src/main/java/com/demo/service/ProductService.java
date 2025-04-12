package com.demo.service;


import com.demo.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> findProductById(Long id);
}
