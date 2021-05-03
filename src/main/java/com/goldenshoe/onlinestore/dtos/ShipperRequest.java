package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Shipper request body")
public class ShipperRequest {
    @Min(1L)
    private Long id;
}
