package com.lessons.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class PaymentServiceClientConfig {

    @Value("${payment-service.auth-token}")
    private String authToken;

    @Bean
    public PaymentAuthInterceptor authInterceptor() {
        return new PaymentAuthInterceptor(authToken);
    }

    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new PaymentErrorDecoder(objectMapper);
    }
}
