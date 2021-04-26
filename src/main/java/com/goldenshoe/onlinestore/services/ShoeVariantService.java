package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ShoeVariantDto;
import com.goldenshoe.onlinestore.models.ShoeVariant;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
public interface ShoeVariantService {
    List<ShoeVariantDto> getAllShoeVariants();

    ShoeVariantDto getShoeVariantById(Long id);

    void updateShoeVariantStock(Long id, int quantity);
}
