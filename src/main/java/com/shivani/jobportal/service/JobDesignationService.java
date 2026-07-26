package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.JobDesignation;
import com.shivani.jobportal.repository.JobDesignationRepository;

@Service
public class JobDesignationService {

    private final JobDesignationRepository repository;

    public JobDesignationService(JobDesignationRepository repository) {
        this.repository = repository;
    }

    // Create Designation
    public JobDesignation createDesignation(JobDesignation designation) {

        JobDesignation existingDesignation =
                repository.findByDesignationName(designation.getDesignationName())
                          .orElse(null);

        if (existingDesignation != null) {
            return null;
        }

        return repository.save(designation);
    }

    // Get All Designations
    public List<JobDesignation> getAllDesignations() {
        return repository.findAll();
    }

    // Get Designation By Id
    public JobDesignation getDesignationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Designation
    public JobDesignation updateDesignation(Long id, JobDesignation newDesignation) {

        JobDesignation existingDesignation =
                repository.findById(id).orElse(null);

        if (existingDesignation == null) {
            return null;
        }

        existingDesignation.setDesignationName(newDesignation.getDesignationName());

        return repository.save(existingDesignation);
    }

    // Delete Designation
    public boolean deleteDesignation(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}