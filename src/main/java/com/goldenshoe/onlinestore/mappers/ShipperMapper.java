package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.ShipperResponse;
import com.goldenshoe.onlinestore.models.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface ShipperMapper {
    ShipperMapper INSTANCE = Mappers.getMapper(ShipperMapper.class);

    ShipperResponse toShipperResponse(Shipper shipper);
}
