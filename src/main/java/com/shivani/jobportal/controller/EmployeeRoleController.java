package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.EmployeeRole;
import com.shivani.jobportal.service.EmployeeRoleService;

@RestController
@RequestMapping("/api/employee-roles")
public class EmployeeRoleController {

    private final EmployeeRoleService roleService;

    public EmployeeRoleController(EmployeeRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public String createRole(@RequestBody EmployeeRole role) {

        EmployeeRole savedRole = roleService.createRole(role);

        if (savedRole != null) {
            return "Employee Role Created Successfully";
        }

        return "Employee Role Already Exists";
    }

    @GetMapping
    public List<EmployeeRole> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public EmployeeRole getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {

        if (roleService.deleteRole(id)) {
            return "Employee Role Deleted Successfully";
        }

        return "Employee Role Not Found";
    }
}