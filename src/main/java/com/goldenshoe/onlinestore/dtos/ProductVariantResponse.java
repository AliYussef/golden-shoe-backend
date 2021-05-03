package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Set;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
@ApiModel(description = "Product Variant response body")
public class ProductVariantResponse {
    private Long id;
    private double price;
    private long stock;
    private Set<ImageResponse> images;
    private ColorResponse color;
    private SizeResponse size;
}
