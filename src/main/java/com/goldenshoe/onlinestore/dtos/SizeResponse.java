package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
@ApiModel(description = "Size response body")
public class SizeResponse {
    private int size;
}
