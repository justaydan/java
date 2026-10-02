package com.lessons.client;

import com.lessons.exception.InvalidRequestException;
import com.lessons.exception.UnauthorizedException;
import com.lessons.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class UserServiceErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String body = extractBody(response);

        return switch (response.status()) {
            case 400 -> new InvalidRequestException("Yanlış sorğu: " + body);
            case 401 -> new UnauthorizedException("İcazəsiz giriş: " + body);
            case 404 -> new UserNotFoundException("İstifadəçi tapılmadı: " + body);
            default -> new RuntimeException("İstifadəçi servisi xətası [" + response.status() + "]: " + body);
        };
    }

    private String extractBody(Response response) {
        if (response.body() == null) {
            return "";
        }
        try (InputStream inputStream = response.body().asInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "response body oxuna bilmədi";
        }
    }
}
