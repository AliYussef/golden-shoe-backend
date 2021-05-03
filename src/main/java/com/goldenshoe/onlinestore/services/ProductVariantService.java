package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ProductVariantResponse;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
public interface ProductVariantService {
    List<ProductVariantResponse> getAllProductVariants();

    ProductVariantResponse getProductVariantById(Long id);

    void updateProductVariantStock(Long id, int quantity);
}
