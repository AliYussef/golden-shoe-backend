package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ProductVariantResponse;
import com.goldenshoe.onlinestore.models.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ProductVariantMapper {
    ProductVariantMapper INSTANCE = Mappers.getMapper(ProductVariantMapper.class);

    ProductVariantResponse toProductVariantResponse(ProductVariant productVariant);
}
