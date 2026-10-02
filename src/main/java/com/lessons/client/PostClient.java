package com.lessons.client;

import com.lessons.model.response.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-client", url = "https://jsonplaceholder.typicode.com", configuration = PostClientConfig.class)
public interface PostClient {

    @GetMapping("/posts/{id}")
    PostResponse getPostById(@PathVariable("id") Long id);
}
