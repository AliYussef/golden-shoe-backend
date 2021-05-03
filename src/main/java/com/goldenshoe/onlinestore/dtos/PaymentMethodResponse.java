package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Payment method response body")
public class PaymentMethodResponse {
    private Long id;
    private String name;
}
