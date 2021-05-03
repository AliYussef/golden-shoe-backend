package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.OrderProductResponse;
import com.goldenshoe.onlinestore.dtos.OrderRequest;
import com.goldenshoe.onlinestore.dtos.OrderResponse;

import java.util.List;

/**
 * Created by aliyussef on 28/04/2021
 */
public interface OrderService {
    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderProductResponse createOrder(OrderRequest request);
}
