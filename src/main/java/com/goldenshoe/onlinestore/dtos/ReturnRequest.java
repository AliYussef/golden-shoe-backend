package com.goldenshoe.onlinestore.dtos;

import com.goldenshoe.onlinestore.models.ReturnReason;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Created by aliyussef on 01/05/2021
 */
@Data
@ApiModel(description = "Return request body")
public class ReturnRequest {

    @NotBlank(message = "reason may not be empty")
    private ReturnReason reason;

    @ApiModelProperty(notes = "Order detail Id that need to be returned")
    @Min(1)
    private Long orderDetailId;
}
