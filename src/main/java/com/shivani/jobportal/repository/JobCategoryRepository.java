package com.shivani.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.JobCategory;

public interface JobCategoryRepository
        extends JpaRepository<JobCategory, Long> {

    Optional<JobCategory> findByCategoryName(String categoryName);

}