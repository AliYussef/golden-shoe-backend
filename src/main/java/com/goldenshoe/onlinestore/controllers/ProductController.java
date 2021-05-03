package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ProductResponse;
import com.goldenshoe.onlinestore.models.ProductTarget;
import com.goldenshoe.onlinestore.services.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * Created by aliyussef on 25/04/2021
 */
@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all products", response = ProductResponse.class)
    public List<ProductResponse> getAllProducts(@RequestParam(required = false) Integer pageNumber,
                                                @RequestParam(required = false) Integer numberOfProducts) {

        if (pageNumber == null || numberOfProducts == null) {
            return productService.getAllProducts();
        }

        return productService.getAllProducts(PageRequest.of(pageNumber, numberOfProducts));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get product by id")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("target/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get product by target")
    public List<ProductResponse> getProductsByTarget(@PathVariable String name) {
        return productService.getProductsByTarget(ProductTarget.valueOf(name.toUpperCase(Locale.ROOT)));
    }

    @GetMapping("category/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get product by category")
    public List<ProductResponse> getProductsByCategory(@PathVariable String name) {
        return productService.getProductsByCategory(name.toLowerCase(Locale.ROOT));
    }
}
