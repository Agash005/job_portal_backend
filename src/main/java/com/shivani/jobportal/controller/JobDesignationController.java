package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.JobDesignation;
import com.shivani.jobportal.service.JobDesignationService;

@RestController
@RequestMapping("/api/designations")
public class JobDesignationController {

    private final JobDesignationService service;

    public JobDesignationController(JobDesignationService service) {
        this.service = service;
    }

    // Create Designation
    @PostMapping("/create")
    public String createDesignation(@RequestBody JobDesignation designation) {

        JobDesignation savedDesignation =
                service.createDesignation(designation);

        if (savedDesignation != null) {
            return "Designation Created Successfully";
        }

        return "Designation Already Exists";
    }

    // Get All Designations
    @GetMapping("/all")
    public List<JobDesignation> getAllDesignations() {
        return service.getAllDesignations();
    }

    // Get Designation By Id
    @GetMapping("/{id}")
    public JobDesignation getDesignationById(@PathVariable Long id) {
        return service.getDesignationById(id);
    }

    // Update Designation
    @PutMapping("/update/{id}")
    public String updateDesignation(@PathVariable Long id,
                                    @RequestBody JobDesignation designation) {

        JobDesignation updatedDesignation =
                service.updateDesignation(id, designation);

        if (updatedDesignation != null) {
            return "Designation Updated Successfully";
        }

        return "Designation Not Found";
    }

    // Delete Designation
    @DeleteMapping("/delete/{id}")
    public String deleteDesignation(@PathVariable Long id) {

        boolean deleted = service.deleteDesignation(id);

        if (deleted) {
            return "Designation Deleted Successfully";
        }

        return "Designation Not Found";
    }

}