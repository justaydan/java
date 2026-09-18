package com.lessons.service;

import com.lessons.model.entity.UserEntity;
import com.lessons.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;


    public List<UserEntity> get() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getById(Long id) {
        return userRepository.findById(id);
    }
}
