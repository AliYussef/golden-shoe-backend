package com.goldenshoe.onlinestore.mappers;

import com.goldenshoe.onlinestore.dtos.OrderRequest;
import com.goldenshoe.onlinestore.dtos.OrderResponse;
import com.goldenshoe.onlinestore.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by aliyussef on 28/04/2021
 */
@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderResponse toOrderResponse(Order order);

    Order toOrder(OrderRequest request);
}
