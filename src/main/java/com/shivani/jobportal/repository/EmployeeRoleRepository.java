package com.shivani.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shivani.jobportal.entity.EmployeeRole;

public interface EmployeeRoleRepository
        extends JpaRepository<EmployeeRole, Long> {

    EmployeeRole findByRoleName(String roleName);
}