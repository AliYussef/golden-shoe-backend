package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ImageResponse;
import com.goldenshoe.onlinestore.models.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    ImageResponse toImageResponse(Image image);
}
