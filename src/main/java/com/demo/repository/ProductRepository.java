package com.demo.repository;

import com.demo.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.Optional;

@ApplicationScoped
@Blocking
public class ProductRepository implements PanacheRepository<Product> {
    public Optional<Product> findProductById(Long id) {
        String sql = """
        select p from Product p where p.id = :productId
        """;
        return find(sql, Parameters.with("productId", id)).stream().findAny();
    }


}
