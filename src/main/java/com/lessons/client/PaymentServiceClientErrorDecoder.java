package com.lessons.client;

import com.lessons.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PaymentServiceClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new NotFoundException("Ödəniş tapılmadı");
            case 400 -> new IllegalArgumentException("Yanlış ödəniş məlumatı");
            case 402 -> new RuntimeException("Ödəniş uğursuz oldu");
            default -> new RuntimeException("Ödəniş servisi xətası: " + response.status());
        };
    }
}
