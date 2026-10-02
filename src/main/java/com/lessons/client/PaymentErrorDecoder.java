package com.lessons.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lessons.exception.AccountBlockedException;
import com.lessons.exception.DailyLimitExceededException;
import com.lessons.exception.InsufficientFundsException;
import com.lessons.exception.PaymentException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PaymentErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    public PaymentErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        String rawBody = extractBody(response);

        try {
            PaymentErrorResponse errorResponse = objectMapper.readValue(rawBody, PaymentErrorResponse.class);
            String errorCode = errorResponse.getErrorCode() != null ? errorResponse.getErrorCode() : "";
            String message = errorResponse.getMessage() != null ? errorResponse.getMessage() : rawBody;

            return switch (errorCode) {
                case "INSUFFICIENT_FUNDS"    -> new InsufficientFundsException(message);
                case "ACCOUNT_BLOCKED"       -> new AccountBlockedException(message);
                case "DAILY_LIMIT_EXCEEDED"  -> new DailyLimitExceededException(message);
                default                      -> new PaymentException("Ödəniş xətası [" + errorCode + "]: " + message);
            };
        } catch (JsonProcessingException e) {
            return new PaymentException("Ödəniş servisi gözlənilməz cavab qaytardı: " + rawBody);
        }
    }

    private String extractBody(Response response) {
        if (response.body() == null) {
            return "";
        }
        try (InputStream inputStream = response.body().asInputStream()) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "";
        }
    }
}
