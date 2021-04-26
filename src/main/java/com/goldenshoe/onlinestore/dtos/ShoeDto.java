package com.goldenshoe.onlinestore.dtos;

import com.goldenshoe.onlinestore.models.ShoeTarget;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by aliyussef on 26/04/2021
 */
@Data
public class ShoeDto {
    private Long id;
    @NotEmpty(message = "name may not be empty")
    @Size(min = 2, message = "name must be at least 2 characters long")
    private String name;
    @NotEmpty(message = "brand may not be empty")
    @Size(min = 2, message = "brand must be at least 2 characters long")
    private String brand;
    private Set<ShoeVariantDto> shoeVariants;
    private Set<CategoryDto> categories;
    private ShoeTarget target;
}
