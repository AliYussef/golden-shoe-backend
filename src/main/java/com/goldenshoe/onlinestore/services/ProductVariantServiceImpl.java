package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ProductVariantResponse;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.mappers.ProductVariantMapper;
import com.goldenshoe.onlinestore.models.ProductVariant;
import com.goldenshoe.onlinestore.repositories.ProductVariantRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 26/04/2021
 */
@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductVariantMapper productVariantMapper;

    public ProductVariantServiceImpl(ProductVariantRepository productVariantRepository, ProductVariantMapper productVariantMapper) {
        this.productVariantRepository = productVariantRepository;
        this.productVariantMapper = productVariantMapper;
    }

    @Override
    public List<ProductVariantResponse> getAllProductVariants() {
        return productVariantRepository
                .findAll()
                .stream()
                .map(productVariantMapper::toProductVariantResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductVariantResponse getProductVariantById(Long id) {
        return productVariantMapper.toProductVariantResponse(findProductVariantById(id));
    }

    @Override
    public void updateProductVariantStock(Long id, int quantity) {
        ProductVariant productVariantSaved = findProductVariantById(id);
        productVariantSaved.setStock(quantity);
        productVariantRepository.save(productVariantSaved);
    }

    private ProductVariant findProductVariantById(Long id) {
        return productVariantRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(MessageFormat.format("Product variant with Id: {0} does not exist!", id)));
    }
}
