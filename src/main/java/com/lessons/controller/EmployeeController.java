package com.lessons.controller;

import com.lessons.entity.EmployeeEntity;
import com.lessons.model.response.EmployeeResponse;
import com.lessons.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> get() {
        List<EmployeeResponse> list = employeeService
                .getEmployee()
                .stream()
                .map(EmployeeResponse::from)
                .toList();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponse>> search(@RequestParam String department) {
        List<EmployeeResponse> list = employeeService
                .getByDepartment(department)
                .stream()
                .map(EmployeeResponse::from)
                .toList();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }
}
