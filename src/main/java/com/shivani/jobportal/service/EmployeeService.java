package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.Employee;
import com.shivani.jobportal.entity.EmployeeRole;
import com.shivani.jobportal.repository.EmployeeRepository;
import com.shivani.jobportal.repository.EmployeeRoleRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRoleRepository roleRepository;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            EmployeeRoleRepository roleRepository) {

        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    // CREATE EMPLOYEE
    public Employee createEmployee(Employee employee) {

        // Check duplicate email
        Employee existingEmployee =
                employeeRepository.findByEmail(employee.getEmail());

        if (existingEmployee != null) {
            return null;
        }

        // Check whether role was provided
        if (employee.getEmployeeRole() == null ||
                employee.getEmployeeRole().getId() == null) {
            return null;
        }

        // Get actual role from database
        Long roleId = employee.getEmployeeRole().getId();

        EmployeeRole role =
                roleRepository.findById(roleId).orElse(null);

        // Invalid role
        if (role == null) {
            return null;
        }

        employee.setEmployeeRole(role);
        employee.setStatus("ACTIVE");

        return employeeRepository.save(employee);
    }

    // GET ALL EMPLOYEES
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET EMPLOYEE BY ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // UPDATE EMPLOYEE
    public Employee updateEmployee(Long id, Employee newEmployee) {

        Employee existingEmployee =
                employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        // Validate role
        if (newEmployee.getEmployeeRole() == null ||
                newEmployee.getEmployeeRole().getId() == null) {
            return null;
        }

        Long roleId = newEmployee.getEmployeeRole().getId();

        EmployeeRole role =
                roleRepository.findById(roleId).orElse(null);

        if (role == null) {
            return null;
        }

        existingEmployee.setEmployeeName(
                newEmployee.getEmployeeName());

        existingEmployee.setEmail(
                newEmployee.getEmail());

        existingEmployee.setPhone(
                newEmployee.getPhone());

        existingEmployee.setEmployeeRole(role);

        return employeeRepository.save(existingEmployee);
    }

    // DELETE EMPLOYEE
    public boolean deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            return false;
        }

        employeeRepository.deleteById(id);

        return true;
    }

    // EMPLOYEE LOGIN
    public Employee login(String email, String password) {

        Employee employee =
                employeeRepository.findByEmail(email);

        if (employee == null) {
            return null;
        }

        if (!employee.getPassword().equals(password)) {
            return null;
        }

        return employee;
    }
}