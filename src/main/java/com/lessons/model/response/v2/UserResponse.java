package com.lessons.model.response.v2;

import com.lessons.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    String name;
    String surname;
    String fullName;

    public static UserResponse from(UserEntity entity) {
        return new UserResponse(
                entity.getName(),
                entity.getSurname(),
                entity.getName() + " " + entity.getSurname()
        );
    }
}
