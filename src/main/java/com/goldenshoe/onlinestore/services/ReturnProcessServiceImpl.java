package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.ReturnProcessResponse;
import com.goldenshoe.onlinestore.mappers.ReturnProcessMapper;
import com.goldenshoe.onlinestore.repositories.ReturnProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 02/05/2021
 */
@Service
public class ReturnProcessServiceImpl implements ReturnProcessService {

    private final ReturnProcessRepository returnProcessRepository;
    private final ReturnProcessMapper returnProcessMapper;

    public ReturnProcessServiceImpl(ReturnProcessRepository returnProcessRepository, ReturnProcessMapper returnProcessMapper) {
        this.returnProcessRepository = returnProcessRepository;
        this.returnProcessMapper = returnProcessMapper;
    }

    @Override
    public List<ReturnProcessResponse> getAllReturnProcessSteps() {
        return returnProcessRepository.findAll()
                .stream()
                .map(returnProcessMapper::toReturnProcessResponse)
                .collect(Collectors.toList());
    }
}
