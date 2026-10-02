package com.lessons.model.response;

import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
