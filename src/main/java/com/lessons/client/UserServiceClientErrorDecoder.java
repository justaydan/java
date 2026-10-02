package com.lessons.client;

import com.lessons.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class UserServiceClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new UserNotFoundException("İstifadəçi tapılmadı");
            case 400 -> new IllegalArgumentException("Yanlış sorğu parametri");
            default -> new RuntimeException("İstifadəçi servisi xətası: " + response.status());
        };
    }
}
