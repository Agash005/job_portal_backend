package com.shivani.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.JobApplication;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

    boolean existsByUserIdAndJobId(Long userId, Long jobId);

    List<JobApplication> findByUserId(Long userId);

    List<JobApplication> findByJobId(Long jobId);
    
    List<JobApplication> findByJobCompanyId(Long companyId);
    
    long countByUserId(Long userId);

    long countByUserIdAndStatus(Long userId, String status);
    
    long countByJobCompanyId(Long companyId);
    
    
    
}