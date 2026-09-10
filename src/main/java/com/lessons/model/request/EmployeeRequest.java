package com.lessons.model.request;

import com.lessons.enums.EmploymentType;
import com.lessons.model.entity.ContactInfo;
import com.lessons.model.entity.DepartmentEntity;
import com.lessons.model.entity.EmployeeEntity;
import com.lessons.model.entity.PersonName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {

    @NotBlank
    private String name;

    @NotNull
    private Double salary;

    @NotNull
    private EmploymentType type;

    @NotNull
    private PersonName personName;

    private ContactInfo contactInfo;

    private Long departmentId;

    public EmployeeEntity toEntity() {
        DepartmentEntity department = departmentId != null ? new DepartmentEntity(departmentId, null) : null;
        return new EmployeeEntity(null, name, department, salary, personName, contactInfo, type);
    }
}
