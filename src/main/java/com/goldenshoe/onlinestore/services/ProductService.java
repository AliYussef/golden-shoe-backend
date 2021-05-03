package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ProductResponse;
import com.goldenshoe.onlinestore.models.ProductTarget;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
public interface ProductService {
    List<ProductResponse> getAllProducts(Pageable pageable);

    List<ProductResponse> getAllProducts();

    ProductResponse getProductById(Long id);

    List<ProductResponse> getProductsByTarget(ProductTarget target);

    List<ProductResponse> getProductsByCategory(String category);
}
