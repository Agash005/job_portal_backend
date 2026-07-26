package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.jobportal.entity.JobApplication;
import com.shivani.jobportal.service.JobApplicationService;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService applicationService;

    public JobApplicationController(
            JobApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    
    @PostMapping("/apply/{userId}/{jobId}")
    public String applyForJob(
            @PathVariable Long userId,
            @PathVariable Long jobId) {

        JobApplication application =
                applicationService.applyForJob(userId, jobId);

        if (application != null) {
            return "Job applied successfully";
        }

        return "Unable to apply for job";
    }

    
    @GetMapping("/user/{userId}")
    public List<JobApplication> getApplicationsByUser(
            @PathVariable Long userId) {

        return applicationService.getApplicationsByUser(userId);
    }

    
    @GetMapping("/job/{jobId}")
    public List<JobApplication> getApplicationsByJob(
            @PathVariable Long jobId) {

        return applicationService.getApplicationsByJob(jobId);
    }
    
    @PutMapping("/{applicationId}/status/{status}")
    public String updateStatus(
            @PathVariable Long applicationId,
            @PathVariable String status) {

        JobApplication application =
                applicationService.updateStatus(applicationId, status);

        if (application != null) {
            return "Application status updated successfully";
        }

        return "Application not found";
    }
    
    @GetMapping("/company/{companyId}")
    public List<JobApplication> getApplicationsByCompany(
            @PathVariable Long companyId) {

        return applicationService.getApplicationsByCompany(companyId);
    }
    
}