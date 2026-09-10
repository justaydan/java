package com.lessons.controller;

import com.lessons.model.request.EmployeeRequest;
import com.lessons.model.response.EmployeeResponse;
import com.lessons.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable Long id, @RequestBody @Valid EmployeeRequest employeeRequest) {
        return EmployeeResponse.from(employeeService.update(id, employeeRequest.toEntity()));
    }

    @PatchMapping("/{id}")
    public EmployeeResponse patch(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        return EmployeeResponse.from(employeeService.patch(id, employeeRequest.toEntity()));
    }
}
