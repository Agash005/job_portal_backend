package com.shivani.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.JobDesignation;

public interface JobDesignationRepository extends JpaRepository<JobDesignation, Long> {

    Optional<JobDesignation> findByDesignationName(String designationName);

}