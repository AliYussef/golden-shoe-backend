package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ShipperResponse;
import com.goldenshoe.onlinestore.services.ShipperService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
@RestController
@RequestMapping("api/v1/shippers")
public class ShipperController {

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all shippers.")
    public List<ShipperResponse> getAllShippers() {
        return shipperService.getAllShippers();
    }
}
