package com.lessons.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String message;
    private Integer status;
    private Instant timestamp;
}
