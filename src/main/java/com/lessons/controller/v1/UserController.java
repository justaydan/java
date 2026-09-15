package com.lessons.controller.v1;

import com.lessons.model.response.v1.UserResponse;
import com.lessons.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController("userControllerV1")
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<UserResponse> get() {
        return userService.get().stream().map(UserResponse::from).toList();
    }
}
