package io.mohkeita.PaymentService.service;

import io.mohkeita.PaymentService.entity.Payment;
import io.mohkeita.PaymentService.model.PaymentMode;
import io.mohkeita.PaymentService.model.PaymentRequest;
import io.mohkeita.PaymentService.model.PaymentResponse;
import io.mohkeita.PaymentService.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording Payment Details: {}", paymentRequest);

        Payment paymentDetails = Payment.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        paymentRepository.save(paymentDetails);
        log.info("Transaction Completed with Id: {}" ,paymentDetails.getId());

        return paymentDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
        log.info("Getting payment details for the Order Id: {}", orderId);

        Payment payment = paymentRepository.findByOrderId(Long.parseLong(orderId));

        return PaymentResponse.builder()
                .paymentId(payment.getId())
                .paymentMode(PaymentMode.valueOf(payment.getPaymentMode()))
                .paymentDate(payment.getPaymentDate())
                .orderId(payment.getOrderId())
                .status(payment.getPaymentStatus())
                .amount(payment.getAmount())
                .build();
    }
}
