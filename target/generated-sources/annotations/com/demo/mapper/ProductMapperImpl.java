package com.demo.mapper;

import com.demo.dto.ProductRestResponse;
import com.demo.model.Product;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-07T21:37:47+0300",
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

        ProductRestResponse productRestResponse = new ProductRestResponse();

        return productRestResponse;
    }
}
