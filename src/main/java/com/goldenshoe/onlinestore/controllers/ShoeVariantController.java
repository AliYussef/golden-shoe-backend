package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ShoeVariantDto;
import com.goldenshoe.onlinestore.services.ShoeVariantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aliyussef on 26/04/2021
 */
@RestController
@RequestMapping("api/v1/shoeVariants")
public class ShoeVariantController {

    private final ShoeVariantService shoeVariantService;

    public ShoeVariantController(ShoeVariantService shoeVariantService) {
        this.shoeVariantService = shoeVariantService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoeVariantDto> getAllShoes() {
        return shoeVariantService.getAllShoeVariants();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoeVariantDto getShoeById(@PathVariable Long id) {
        return shoeVariantService.getShoeVariantById(id);
    }

    @PutMapping("{id}/stock/{quantity}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Stock has been updated.")
    public void updateShoeStock(@PathVariable Long id, @PathVariable int quantity) {
        shoeVariantService.updateShoeVariantStock(id, quantity);
    }
}
