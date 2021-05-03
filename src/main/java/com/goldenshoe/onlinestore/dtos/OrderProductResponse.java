package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@Builder
@ApiModel(description = "Order product response body")
public class OrderProductResponse {
    private Long orderId;
    private String paymentLink;
}
