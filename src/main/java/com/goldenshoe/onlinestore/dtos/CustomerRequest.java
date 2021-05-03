package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Customer request body")
public class CustomerRequest {
    @NotEmpty(message = "firstName may not be empty")
    @Size(min = 2, max = 32, message = "firstName must be between 2 and 32 characters long")
    private String firstName;

    @NotEmpty(message = "lastName may not be empty")
    @Size(min = 2, max = 32, message = "lastName must be between 2 and 32 characters long")
    private String lastName;

    @Email
    @NotEmpty(message = "email may not be empty")
    private String email;

    @NotEmpty(message = "phoneNumber may not be empty")
    private String phoneNumber;
}
