package com.lessons.client;

import org.springframework.stereotype.Component;

@Component
public class PaymentClientFallback implements PaymentServiceClient {

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        return PaymentResponse.failed("Ödəniş servisi əlçatmazdır, zəhmət olmasa bir az sonra cəhd edin");
    }

    @Override
    public PaymentResponse getPayment(String transactionId) {
        return PaymentResponse.failed("Ödəniş məlumatı əlçatmazdır, zəhmət olmasa bir az sonra cəhd edin");
    }
}
