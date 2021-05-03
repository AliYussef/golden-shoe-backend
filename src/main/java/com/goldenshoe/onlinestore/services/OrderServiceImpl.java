package com.goldenshoe.onlinestore.services;

import com.goldenshoe.onlinestore.dtos.OrderDetailRequest;
import com.goldenshoe.onlinestore.dtos.OrderProductResponse;
import com.goldenshoe.onlinestore.dtos.OrderRequest;
import com.goldenshoe.onlinestore.dtos.OrderResponse;
import com.goldenshoe.onlinestore.exceptions.ProductOutOfStockException;
import com.goldenshoe.onlinestore.exceptions.ResourceNotFoundException;
import com.goldenshoe.onlinestore.mappers.OrderMapper;
import com.goldenshoe.onlinestore.models.*;
import com.goldenshoe.onlinestore.repositories.*;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aliyussef on 28/04/2021
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductVariantRepository productVariantRepository;
    private final ShipperRepository shipperRepository;
    private final VoucherRepository voucherRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ProductVariantRepository productVariantRepository,
                            ShipperRepository shipperRepository, VoucherRepository voucherRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productVariantRepository = productVariantRepository;
        this.shipperRepository = shipperRepository;
        this.voucherRepository = voucherRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderMapper.toOrderResponse(orderRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(MessageFormat.format("Order with Id: {0} does not exist!", id))));
    }

    @Override
    public OrderProductResponse createOrder(OrderRequest request) {
        Order order = orderMapper.toOrder(request);
        order.getShippingAddress().setCustomer(order.getCustomer());
        order.getBillingAddress().setCustomer(order.getCustomer());

        LocalDate expectedDeliveryDate = getExpectedDeliveryDate(request.getShipper().getId());
        order.setExpectedDeliveryDate(expectedDeliveryDate);

        processProducts(request.getOrderDetailsRequest(), order);
        checkVoucherDiscount(request.getVoucherId(), order);

        Order savedOrder = orderRepository.save(order);
        return OrderProductResponse
                .builder()
                .orderId(savedOrder.getId())
                .paymentLink("https://paymentlink.com")
                .build();
    }

    private void processProducts(List<OrderDetailRequest> orderDetailsRequest, Order order) {
        Set<OrderDetail> orderDetails = new HashSet<>();
        double amount = 0;
        double totalAmount = 0;

        for (int i = 0; i < orderDetailsRequest.size(); i++) {
            Long productId = orderDetailsRequest.get(i).getProductId();
            int quantity = orderDetailsRequest.get(i).getQuantity();

            ProductVariant productVariant = productVariantRepository.findById(productId)
                    .orElseThrow(() ->
                            new ResourceNotFoundException(MessageFormat
                                    .format("Product variant with Id: {0} does not exist!", productId)));

            if (productVariant.getStock() < quantity) {
                throw new ProductOutOfStockException(MessageFormat.format("Product variant with Id: {0} is out of stock", productId));
            }

            amount = productVariant.getPrice() * quantity;
            for (int j = 0; j < quantity; j++) {
                orderDetails.add(OrderDetail
                        .builder()
                        .amount(productVariant.getPrice())
                        .productVariant(productVariant)
                        .order(order)
                        .build());
            }

            totalAmount += amount;
            amount = 0;
        }

        order.setOrderDetail(orderDetails);
        order.setTotalAmount(Math.round(totalAmount * 100.0) / 100.0);
    }

    private void checkVoucherDiscount(Long voucherId, Order order) {
        if (voucherId <= 0) return;
        Voucher voucher = voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format("Voucher with Id: {0} does not exist!", voucherId)));

        double totalAmountWithDiscount = order.getTotalAmount() - (order.getTotalAmount() * (voucher.getDiscountPercentage() / 100.0));
        order.setTotalAmount(Math.round(totalAmountWithDiscount * 100.0) / 100.0);
        order.setVoucher(Voucher.builder().id(voucher.getId()).build());
    }

    private LocalDate getExpectedDeliveryDate(Long shipperId) {
        Shipper shipper = shipperRepository.findById(shipperId).orElseThrow(() ->
                new ResourceNotFoundException(MessageFormat.format("Shipper with Id: {0} does not exist!", shipperId)));

        return LocalDate.now().plusDays(shipper.getDeliveryDurationInDays());
    }
}
