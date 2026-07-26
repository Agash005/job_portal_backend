package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.EmployeeRole;
import com.shivani.jobportal.repository.EmployeeRoleRepository;

@Service
public class EmployeeRoleService {

    private final EmployeeRoleRepository roleRepository;

    public EmployeeRoleService(EmployeeRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public EmployeeRole createRole(EmployeeRole role) {

        EmployeeRole existing =
                roleRepository.findByRoleName(role.getRoleName());

        if (existing != null) {
            return null;
        }

        return roleRepository.save(role);
    }

    public List<EmployeeRole> getAllRoles() {
        return roleRepository.findAll();
    }

    public EmployeeRole getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public boolean deleteRole(Long id) {

        if (!roleRepository.existsById(id)) {
            return false;
        }

        roleRepository.deleteById(id);
        return true;
    }
}