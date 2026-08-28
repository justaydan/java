package com.lessons.entity;

import com.lessons.enums.EmploymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    private DepartmentEntity department;

    private Double salary;

    @Embedded
    private PersonName personName;

    @Embedded
    private ContactInfo contactInfo;

    @Enumerated(EnumType.STRING)
    private EmploymentType type;


}
