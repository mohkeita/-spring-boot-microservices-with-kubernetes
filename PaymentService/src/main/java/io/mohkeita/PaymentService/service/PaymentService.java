package io.mohkeita.PaymentService.service;

import io.mohkeita.PaymentService.model.PaymentRequest;
import io.mohkeita.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
