package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 02/05/2021
 */
@Data
@ApiModel(description = "Return process response body")
public class ReturnProcessResponse {
    private int step;
    private String title;
    private String description;
}
