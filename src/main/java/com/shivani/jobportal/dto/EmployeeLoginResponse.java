package com.shivani.jobportal.dto;

import com.shivani.jobportal.entity.EmployeeRole;

public class EmployeeLoginResponse {

    private Long id;
    private String employeeName;
    private String email;
    private String phone;
    private EmployeeRole employeeRole;
    private String status;

    public EmployeeLoginResponse() {
    }

    public EmployeeLoginResponse(Long id,
                                 String employeeName,
                                 String email,
                                 String phone,
                                 EmployeeRole employeeRole,
                                 String status) {

        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.employeeRole = employeeRole;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public String getStatus() {
        return status;
    }
}