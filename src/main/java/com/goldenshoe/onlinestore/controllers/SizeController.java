package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.models.Size;
import com.goldenshoe.onlinestore.repositories.SizeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aliyussef on 25/04/2021
 */
@RestController
@RequestMapping("api/v1/sizes")
public class SizeController {

    private final SizeRepository sizeRepository;

    public SizeController(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Size> getAllShoes() {
        return sizeRepository.findAll();
    }


}
