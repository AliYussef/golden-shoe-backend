package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ProductVariantResponse;
import com.goldenshoe.onlinestore.services.ProductVariantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
@RestController
@RequestMapping("api/v1/productVariants")
public class ProductVariantController {

    private final ProductVariantService productVariantService;

    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all product variants")
    public List<ProductVariantResponse> getAllProductVariants() {
        return productVariantService.getAllProductVariants();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get product variant by id")
    public ProductVariantResponse getProductsVariantById(@PathVariable Long id) {
        return productVariantService.getProductVariantById(id);
    }

    @PutMapping("{id}/stock/{quantity}")
    @ApiOperation(value = "Update product variant stock")
    @ResponseStatus(value = HttpStatus.OK, reason = "Stock has been updated.")
    public void updateProductVariantStock(@PathVariable Long id, @PathVariable int quantity) {
        productVariantService.updateProductVariantStock(id, quantity);
    }
}
