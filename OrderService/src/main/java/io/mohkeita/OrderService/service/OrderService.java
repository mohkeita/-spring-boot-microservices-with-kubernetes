package io.mohkeita.OrderService.service;

import io.mohkeita.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
