package com.lessons.controller;

import com.lessons.exception.UserNotFoundException;
import com.lessons.model.response.ErrorResponseDto;
import com.lessons.model.response.v1.UserResponse;
import com.lessons.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserResponse> get() {
        return userService.get().stream().map(UserResponse::from).toList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be a positive number");
        }
        UserResponse user = userService.getById(id).map(UserResponse::from)
                .orElseThrow(() -> new UserNotFoundException("User not found for id: " + id));
        return ResponseEntity.ok(user);
    }
}
