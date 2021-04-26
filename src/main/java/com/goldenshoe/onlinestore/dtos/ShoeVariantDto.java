package com.goldenshoe.onlinestore.dtos;

import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Set;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
public class ShoeVariantDto {
    private Long id;
    @Min(value = 1, message = "price should be bigger than 1")
    private double price;
    private long stock;
    private Set<ImageDto> images;
    private ColorDto color;
    private SizeDto size;
}
