package com.lessons.model.request;

import lombok.Data;

@Data
public class EmployeePatchDto {
    private String name;
    private Long departmentId;
    private Double salary;
    private String email;
}
