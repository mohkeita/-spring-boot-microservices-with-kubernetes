package io.mohkeita.OrderService.service;

import io.mohkeita.OrderService.model.OrderRequest;
import io.mohkeita.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
