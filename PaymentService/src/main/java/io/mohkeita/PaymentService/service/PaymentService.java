package io.mohkeita.PaymentService.service;

import io.mohkeita.PaymentService.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
