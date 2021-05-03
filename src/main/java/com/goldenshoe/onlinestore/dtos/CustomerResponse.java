package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Customer response body")
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
