package com.example.ordermicroservice.service;

import com.example.ordermicroservice.domain.OrderEntity;
import com.example.ordermicroservice.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDetails);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrdersByUserId(String userId);
}
