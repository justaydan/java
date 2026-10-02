package com.lessons.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class PaymentAuthInterceptor implements RequestInterceptor {

    private final String authToken;

    public PaymentAuthInterceptor(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + authToken);
    }
}
