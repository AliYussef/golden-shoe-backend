package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Order detail request body")
public class OrderDetailRequest {
    private Long productId;
    private int quantity;
}
