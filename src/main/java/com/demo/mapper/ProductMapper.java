package com.demo.mapper;

import com.demo.model.Product;
import com.demo.dto.ProductRestResponse;
import org.mapstruct.Mapper;

@Mapper(config = QuarkusMappingConfig.class)
public interface ProductMapper {

    // @Mapping(target = "name", source = "name")
    // Source refers to the input(Entity)
    // Target refers to the output(DTO)
    // TargetType methodName(SourceType source);
    ProductRestResponse mapProductToProductRestResponse(Product product);
}
