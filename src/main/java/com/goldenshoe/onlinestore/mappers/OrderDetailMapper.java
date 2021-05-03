package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.OrderDetailResponse;
import com.goldenshoe.onlinestore.models.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);
}
