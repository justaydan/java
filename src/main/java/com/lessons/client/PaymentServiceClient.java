package com.lessons.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service-client",
        url = "${payment-service.url}",
        configuration = PaymentServiceClientConfig.class,
        fallback = PaymentClientFallback.class
)
public interface PaymentServiceClient {

    @PostMapping("/api/payments")
    PaymentResponse processPayment(@RequestBody PaymentRequest request);

    @GetMapping("/api/payments/{transactionId}")
    PaymentResponse getPayment(@PathVariable("transactionId") String transactionId);
}
