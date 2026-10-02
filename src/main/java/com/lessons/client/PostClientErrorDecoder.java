package com.lessons.client;

import com.lessons.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PostClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new NotFoundException("Post tapılmadı");
            case 400 -> new IllegalArgumentException("Yanlış sorğu parametri");
            default -> new RuntimeException("Xarici servis xətası: " + response.status());
        };
    }
}
