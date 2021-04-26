package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ColorDto;
import com.goldenshoe.onlinestore.models.Color;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ColorMapper {
    ColorMapper INSTANCE = Mappers.getMapper(ColorMapper.class);

    ColorDto colorToColorDto(Color color);
}
