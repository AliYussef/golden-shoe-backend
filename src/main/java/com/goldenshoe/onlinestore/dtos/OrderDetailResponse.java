package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Order detail response body")
public class OrderDetailResponse {
    private double amount;
    private int quantity;
    private ProductVariantResponse productVariant;
}
