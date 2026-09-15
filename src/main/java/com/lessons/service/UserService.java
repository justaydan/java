package com.lessons.service;

import com.lessons.model.entity.UserEntity;
import com.lessons.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;


    public List<UserEntity> get() {
        return userRepository.findAll();
    }
}
