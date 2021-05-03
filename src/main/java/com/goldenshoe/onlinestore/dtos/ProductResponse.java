package com.goldenshoe.onlinestore.dtos;

import com.goldenshoe.onlinestore.models.ProductTarget;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Set;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
@ApiModel(description = "Product response body")
public class ProductResponse {
    private Long id;
    private String name;
    private String brand;
    private String imagePath;
    private double price;
    private Set<ProductVariantResponse> productVariants;
    private Set<CategoryResponse> categories;
    private ProductTarget target;
}
