package com.shivani.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByEmail(String email);

    List<Company> findByStatus(String status);
}