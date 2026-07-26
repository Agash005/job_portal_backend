package com.shivani.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByCategoryId(Long categoryId);

    List<Job> findByDesignationId(Long designationId);

    List<Job> findByLocationId(Long locationId);

    List<Job> findBySkillId(Long skillId);

    List<Job> findByExperience(Integer experience);

    List<Job> findByQualification(String qualification);

    List<Job> findByCompanyId(Long companyId);

    List<Job> findByStatus(String status);

    List<Job> findBySalaryBetween(Double minSalary, Double maxSalary);
    
    long countByCompanyId(Long companyId);

    long countByCompanyIdAndStatus(Long companyId, String status);

}