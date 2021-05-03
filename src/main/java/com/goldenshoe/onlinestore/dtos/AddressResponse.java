package com.goldenshoe.onlinestore.dtos;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by aliyussef on 29/04/2021
 */
@Data
@ApiModel(description = "Address response body")
public class AddressResponse {
    private String streetName;
    private String houseNumber;
    private String zipcode;
    private String city;
    private String country;
}
