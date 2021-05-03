package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ReturnRequest;
import com.goldenshoe.onlinestore.dtos.ReturnResponse;
import com.goldenshoe.onlinestore.services.ReturnService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
@RestController
@RequestMapping("api/v1/returns")
public class ReturnController {

    private final ReturnService returnService;

    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Request a product return.")
    public ReturnResponse requestProductReturn(@Valid @RequestBody List<ReturnRequest> requests) {
        return returnService.requestProductReturn(requests);
    }
}
