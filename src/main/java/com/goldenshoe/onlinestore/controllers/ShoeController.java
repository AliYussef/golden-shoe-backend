package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ShoeDto;
import com.goldenshoe.onlinestore.models.ShoeTarget;
import com.goldenshoe.onlinestore.services.ShoeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

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
    public List<ShoeDto> getAllShoes(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer numberOfProducts) {

        if (pageNumber == null || numberOfProducts == null) {
            return shoeService.getAllShoes();
        }

        return shoeService.getAllShoes(PageRequest.of(pageNumber, numberOfProducts));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoeDto getShoeById(@PathVariable Long id) {
        return shoeService.getShoeById(id);
    }

    @GetMapping("target/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ShoeDto> getShoesByTarget(@PathVariable String name) {
        return shoeService.getShoesByTarget(ShoeTarget.valueOf(name.toUpperCase(Locale.ROOT)));
    }

    @GetMapping("category/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ShoeDto> getShoesByCategory(@PathVariable String name) {
        return shoeService.getShoesByCategory(name);
    }
}
