package com.lessons.model.response;

import com.lessons.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private Double salary;
    private Long department_id;

    public static EmployeeResponse from(EmployeeEntity entity) {
        return new EmployeeResponse(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getDepartment() != null ? entity.getDepartment().getId() : null
        );
    }
}
