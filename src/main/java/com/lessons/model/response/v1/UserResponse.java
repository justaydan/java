package com.lessons.model.response.v1;

import com.lessons.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    String name;
    String surname;

    public static UserResponse from(UserEntity userEntity) {
        return new UserResponse(userEntity.getName(), userEntity.getSurname());
    }
}
