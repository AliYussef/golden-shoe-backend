package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
@ApiModel(description = "Color response body")
public class ColorResponse {
    private String name;
}
