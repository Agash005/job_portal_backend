package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.Employee;
import com.shivani.jobportal.service.EmployeeService;
import com.shivani.jobportal.dto.EmployeeLoginResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Admin Creates Employee
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {

        Employee savedEmployee =
                employeeService.createEmployee(employee);

        if (savedEmployee != null) {
            return "Employee Created Successfully";
        }

        return "Employee Email Already Exists";
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        Employee updatedEmployee =
                employeeService.updateEmployee(id, employee);

        if (updatedEmployee != null) {
            return "Employee Updated Successfully";
        }

        return "Employee Not Found";
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return "Employee Deleted Successfully";
        }

        return "Employee Not Found";
    }

    // Employee Login
    @PostMapping("/login")
    public EmployeeLoginResponse login(@RequestBody Employee loginEmployee) {

        Employee employee = employeeService.login(
                loginEmployee.getEmail(),
                loginEmployee.getPassword()
        );

        if (employee == null) {
            return null;
        }

        return new EmployeeLoginResponse(
                employee.getId(),
                employee.getEmployeeName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getEmployeeRole(),
                employee.getStatus()
        );
    }
}