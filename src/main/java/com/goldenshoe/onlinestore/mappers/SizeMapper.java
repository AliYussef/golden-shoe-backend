package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.SizeResponse;
import com.goldenshoe.onlinestore.models.Size;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface SizeMapper {
    SizeMapper INSTANCE = Mappers.getMapper(SizeMapper.class);

    SizeResponse toSizeResponse(Size size);
}
