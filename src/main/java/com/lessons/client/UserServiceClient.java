package com.lessons.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "user-service-client",
        url = "${user-service.url}",
        configuration = UserServiceClientConfig.class
)
public interface UserServiceClient {

    @GetMapping("/api/users/{id}")
    UserServiceResponse getUserById(@PathVariable("id") Long id);
}
