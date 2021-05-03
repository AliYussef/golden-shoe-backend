package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Created by aliyussef on 29/04/2021
 */
@Valid
@Data
@ApiModel(description = "Payment method request body")
public class PaymentMethodRequest {
    @Min(1L)
    private Long id;
}
