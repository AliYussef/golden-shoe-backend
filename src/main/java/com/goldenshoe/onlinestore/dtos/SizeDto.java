package com.goldenshoe.onlinestore.dtos;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
public class SizeDto {
    @Min(value = 1, message = "size should be bigger than 1")
    private int size;
}
