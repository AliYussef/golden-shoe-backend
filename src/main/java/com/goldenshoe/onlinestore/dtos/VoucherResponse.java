package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Voucher response body")
public class VoucherResponse {
    private Long id;
    private String code;
    private int discountPercentage;
}
