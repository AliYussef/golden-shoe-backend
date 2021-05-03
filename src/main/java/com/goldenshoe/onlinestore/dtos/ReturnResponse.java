package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * Created by aliyussef on 01/05/2021
 */
@Data
@Builder
@ApiModel(description = "Return response body")
public class ReturnResponse {
    private String message;
}
