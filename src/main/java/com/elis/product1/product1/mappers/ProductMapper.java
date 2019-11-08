package com.elis.product1.product1.mappers;

import com.elis.product1.product1.entities.Product;
import com.elis.product1.product1.entities.dtos.product.create.CreateProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(CreateProductDto dto);


}
