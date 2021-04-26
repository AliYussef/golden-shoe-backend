package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ShoeVariantDto;
import com.goldenshoe.onlinestore.models.ShoeVariant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ShoeVariantMapper {
    ShoeVariantMapper INSTANCE = Mappers.getMapper(ShoeVariantMapper.class);

    ShoeVariantDto shoeVariantToShoeVariantDto(ShoeVariant shoeVariant);
}
