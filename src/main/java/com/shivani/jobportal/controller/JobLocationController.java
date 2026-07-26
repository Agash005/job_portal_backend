package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.JobLocation;
import com.shivani.jobportal.service.JobLocationService;

@RestController
@RequestMapping("/api/locations")
public class JobLocationController {

    private final JobLocationService service;

    public JobLocationController(JobLocationService service) {
        this.service = service;
    }

    // Create Location
    @PostMapping("/create")
    public String createLocation(@RequestBody JobLocation location) {

        JobLocation savedLocation = service.createLocation(location);

        if (savedLocation != null) {
            return "Location Created Successfully";
        }

        return "Location Already Exists";
    }

    // Get All Locations
    @GetMapping("/all")
    public List<JobLocation> getAllLocations() {
        return service.getAllLocations();
    }

    // Get Location By Id
    @GetMapping("/{id}")
    public JobLocation getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    // Update Location
    @PutMapping("/update/{id}")
    public String updateLocation(@PathVariable Long id,
                                 @RequestBody JobLocation location) {

        JobLocation updatedLocation =
                service.updateLocation(id, location);

        if (updatedLocation != null) {
            return "Location Updated Successfully";
        }

        return "Location Not Found";
    }

    // Delete Location
    @DeleteMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {

        boolean deleted = service.deleteLocation(id);

        if (deleted) {
            return "Location Deleted Successfully";
        }

        return "Location Not Found";
    }
}