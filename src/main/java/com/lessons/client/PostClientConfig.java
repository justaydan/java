package com.lessons.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PostClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new PostClientErrorDecoder();
    }
}
