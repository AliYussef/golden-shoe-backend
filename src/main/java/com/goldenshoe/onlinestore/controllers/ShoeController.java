package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.services.ShoeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aliyussef on 25/04/2021
 */
@RestController
@RequestMapping("api/v1/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ShoeDto> getAllShoes() {
        return shoeService.getAllShoes();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoeDto getShoeById(@PathVariable Long id) {
        return shoeService.getShoeById(id);
    }
}
