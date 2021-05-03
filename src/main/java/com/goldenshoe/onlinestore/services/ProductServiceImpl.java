package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ProductResponse;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.mappers.ProductMapper;
import com.goldenshoe.onlinestore.models.ProductTarget;
import com.goldenshoe.onlinestore.repositories.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 26/04/2021
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getAllProducts(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.toProductResponse(productRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(MessageFormat.format("Product with Id: {0} does not exist!", id))));
    }

    @Override
    public List<ProductResponse> getProductsByTarget(ProductTarget target) {
        return productRepository
                .findAllByTarget(target)
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        return productRepository
                .findAll()
                .stream()
                .filter(shoe -> shoe.getCategories()
                        .stream()
                        .anyMatch(category1 -> category1
                                .getName()
                                .toLowerCase(Locale.ROOT)
                                .equals(category)))
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
