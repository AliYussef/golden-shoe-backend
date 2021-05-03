package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Shipper response body")
public class ShipperResponse {
    private Long id;
    private String name;
    private double price;
}
