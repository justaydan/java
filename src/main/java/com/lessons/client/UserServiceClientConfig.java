package com.lessons.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class UserServiceClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserServiceClientErrorDecoder();
    }
}
