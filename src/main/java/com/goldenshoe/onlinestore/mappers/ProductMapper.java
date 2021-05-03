package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ProductResponse;
import com.goldenshoe.onlinestore.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponse toProductResponse(Product product);
}
