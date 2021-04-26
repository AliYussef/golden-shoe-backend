package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.CategoryDto;
import com.goldenshoe.onlinestore.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(Category category);
}
