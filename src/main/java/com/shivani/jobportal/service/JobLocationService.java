package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.JobLocation;
import com.shivani.jobportal.repository.JobLocationRepository;

@Service
public class JobLocationService {

    private final JobLocationRepository repository;

    public JobLocationService(JobLocationRepository repository) {
        this.repository = repository;
    }

    // Create Location
    public JobLocation createLocation(JobLocation location) {

        JobLocation existingLocation =
                repository.findByLocationName(location.getLocationName())
                          .orElse(null);

        if (existingLocation != null) {
            return null;
        }

        return repository.save(location);
    }

    // Get All Locations
    public List<JobLocation> getAllLocations() {
        return repository.findAll();
    }

    // Get Location By Id
    public JobLocation getLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Location
    public JobLocation updateLocation(Long id, JobLocation newLocation) {

        JobLocation existingLocation =
                repository.findById(id).orElse(null);

        if (existingLocation == null) {
            return null;
        }

        existingLocation.setLocationName(newLocation.getLocationName());

        return repository.save(existingLocation);
    }

    // Delete Location
    public boolean deleteLocation(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}