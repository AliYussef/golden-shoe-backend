package com.goldenshoe.onlinestore.controllers;

import com.goldenshoe.onlinestore.dtos.ReturnProcessResponse;
import com.goldenshoe.onlinestore.services.ReturnProcessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by aliyussef on 02/05/2021
 */
@RestController
@RequestMapping("api/v1/returnProcesses")
public class ReturnProcessController {

    private final ReturnProcessService returnProcessService;

    public ReturnProcessController(ReturnProcessService returnProcessService) {
        this.returnProcessService = returnProcessService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all return process steps.")
    public List<ReturnProcessResponse> getAllReturnProcessSteps() {
        return returnProcessService.getAllReturnProcessSteps();
    }
}
