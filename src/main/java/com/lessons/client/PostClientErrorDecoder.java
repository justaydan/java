package com.lessons.client;

import com.lessons.exception.PostNotFoundException;
import com.lessons.exception.ServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PostClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 404 -> new PostNotFoundException("Post tapılmadı: " + methodKey);
            case 500 -> new ServiceUnavailableException("Xarici servis əlçatmazdır");
            default -> new RuntimeException("Xarici servis xətası: " + response.status());
        };
    }
}
