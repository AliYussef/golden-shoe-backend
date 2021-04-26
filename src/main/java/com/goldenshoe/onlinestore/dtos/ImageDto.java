package com.goldenshoe.onlinestore.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
public class ImageDto {
    @NotEmpty(message = "path may not be empty")
    @Size(min = 2, message = "path must be at least 2 characters long")
    private String path;
}
