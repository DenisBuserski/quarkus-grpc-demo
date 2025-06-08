package com.demo.mapper;

import com.demo.dto.ProductRestResponse;
import com.demo.model.Product;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T14:00:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Singleton
@Named
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductRestResponse mapProductToProductRestResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRestResponse.ProductRestResponseBuilder productRestResponse = ProductRestResponse.builder();

        productRestResponse.name( product.getName() );
        productRestResponse.price( product.getPrice() );
        productRestResponse.quantity( product.getQuantity() );

        return productRestResponse.build();
    }
}
