package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.config.StorePolicy;
import com.goldenshoe.onlinestore.dtos.ReturnRequest;
import com.goldenshoe.onlinestore.dtos.ReturnResponse;
import com.goldenshoe.onlinestore.exceptions.ProductReturnPeriodExpiredException;
import com.goldenshoe.onlinestore.exceptions.VoucherNotActiveException;
import com.goldenshoe.onlinestore.models.OrderDetail;
import com.goldenshoe.onlinestore.models.Return;
import com.goldenshoe.onlinestore.repositories.OrderDetailRepository;
import com.goldenshoe.onlinestore.repositories.ReturnRepository;
import com.goldenshoe.onlinestore.utils.DateExtension;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by aliyussef on 01/05/2021
 */
@Service
public class ReturnServiceImpl implements ReturnService {

    private final ReturnRepository returnRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final StorePolicy storePolicy;

    public ReturnServiceImpl(ReturnRepository returnRepository, OrderDetailRepository orderDetailRepository, StorePolicy storePolicy) {
        this.returnRepository = returnRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.storePolicy = storePolicy;
    }

    @Override
    public ReturnResponse requestProductReturn(List<ReturnRequest> requests) {

        for (int i = 0; i < requests.size(); i++) {
            processReturnRequest(requests.get(i));
        }

        return ReturnResponse
                .builder()
                .message("Return request has been successfully processed.")
                .build();
    }

    /**
     * Process the return request.
     */
    private void processReturnRequest(ReturnRequest request) {
        OrderDetail orderDetail = getOrderDetail(request.getOrderDetailId());

        if (checkReturnValidity(DateExtension.convertToLocalDateViaInstant(orderDetail.getCreatedAt()))) {
            throw new ProductReturnPeriodExpiredException(MessageFormat
                    .format("Product with Id: {0} cannot be returned, because it has exceeded the allowed return period of {1} days.",
                            orderDetail.getId(), storePolicy.getReturnPeriod()));
        }

        Return returnRequest = Return
                .builder()
                .reason(request.getReason())
                .build();

        Return savedReturn = returnRepository.save(returnRequest);

        orderDetail.setItemReturn(savedReturn);
        orderDetailRepository.save(orderDetail);
    }

    private OrderDetail getOrderDetail(Long id) {
        return orderDetailRepository
                .findById(id)
                .orElseThrow(() -> new VoucherNotActiveException(MessageFormat
                        .format("Order detail with Id: {0} has already been used!", id)));
    }

    /**
     * Check if the return request is valid by comparing order date with store return policy period.
     */
    private boolean checkReturnValidity(LocalDate orderCreatedDate) {
        return orderCreatedDate.plusDays(storePolicy.getReturnPeriod()).isBefore(LocalDate.now()) ||
                orderCreatedDate.plusDays(storePolicy.getReturnPeriod()).isEqual(LocalDate.now());

    }
}
