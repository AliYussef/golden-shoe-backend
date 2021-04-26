package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.models.Shoe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 26/04/2021
 */
@Mapper
public interface ShoeMapper {
    ShoeMapper INSTANCE = Mappers.getMapper(ShoeMapper.class);

    ShoeDto shoeToShoeDto(Shoe shoe);
}
