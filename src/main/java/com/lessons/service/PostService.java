package com.lessons.service;

import com.lessons.client.PostClient;
import com.lessons.model.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostClient postClient;

    public PostResponse getPostById(Long id) {
        return postClient.getPostById(id);
    }
}
