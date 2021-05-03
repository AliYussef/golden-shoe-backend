package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Address request body")
public class AddressRequest {
    @NotEmpty(message = "streetName may not be empty")
    @Size(min = 2, max = 32, message = "streetName must be between 2 and 32 characters long")
    private String streetName;

    @NotEmpty(message = "houseNumber may not be empty")
    private String houseNumber;

    @NotEmpty(message = "zipcode may not be empty")
    @Size(min = 2, max = 32, message = "zipcode must be between 2 and 32 characters long")
    private String zipcode;

    @NotEmpty(message = "city may not be empty")
    @Size(min = 2, max = 32, message = "city must be between 2 and 32 characters long")
    private String city;

    @NotEmpty(message = "country may not be empty")
    @Size(min = 2, max = 32, message = "country must be between 2 and 32 characters long")
    private String country;
}
