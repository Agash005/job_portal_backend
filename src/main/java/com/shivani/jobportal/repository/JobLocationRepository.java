package com.shivani.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.JobLocation;

public interface JobLocationRepository extends JpaRepository<JobLocation, Long> {

    Optional<JobLocation> findByLocationName(String locationName);

}