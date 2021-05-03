package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
@ApiModel(description = "Category response body")
public class CategoryResponse {
    @NotEmpty(message = "name may not be empty")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;
}
