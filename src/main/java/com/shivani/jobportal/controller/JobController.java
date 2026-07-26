package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.Job;
import com.shivani.jobportal.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // Create Job
    @PostMapping("/create/{companyId}/{categoryId}/{designationId}/{locationId}/{skillId}")
    public String createJob(@PathVariable Long companyId,
                            @PathVariable Long categoryId,
                            @PathVariable Long designationId,
                            @PathVariable Long locationId,
                            @PathVariable Long skillId,
                            @RequestBody Job job) {

        Job savedJob = service.createJob(
                companyId,
                categoryId,
                designationId,
                locationId,
                skillId,
                job);

        if (savedJob != null) {
            return "Job Created Successfully";
        }

        return "Invalid Company, Category, Designation, Location or Skill";
    }

    // Get All Jobs
    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return service.getAllJobs();
    }

    // Get Job By Id
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return service.getJobById(id);
    }

    // Update Job
    @PutMapping("/update/{id}")
    public String updateJob(@PathVariable Long id,
                            @RequestBody Job job) {

        Job updatedJob = service.updateJob(id, job);

        if (updatedJob != null) {
            return "Job Updated Successfully";
        }

        return "Job Not Found";
    }

    // Delete Job
    @DeleteMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {

        boolean deleted = service.deleteJob(id);

        if (deleted) {
            return "Job Deleted Successfully";
        }

        return "Job Not Found";
    }

    // Close Job
    @PutMapping("/close/{id}")
    public String closeJob(@PathVariable Long id) {

        Job closedJob = service.closeJob(id);

        if (closedJob != null) {
            return "Job Closed Successfully";
        }

        return "Job Not Found";
    }

    // Search By Category
    @GetMapping("/category/{categoryId}")
    public List<Job> getJobsByCategory(@PathVariable Long categoryId) {
        return service.getJobsByCategory(categoryId);
    }

    // Search By Designation
    @GetMapping("/designation/{designationId}")
    public List<Job> getJobsByDesignation(@PathVariable Long designationId) {
        return service.getJobsByDesignation(designationId);
    }

    // Search By Location
    @GetMapping("/location/{locationId}")
    public List<Job> getJobsByLocation(@PathVariable Long locationId) {
        return service.getJobsByLocation(locationId);
    }

    // Search By Skill
    @GetMapping("/skill/{skillId}")
    public List<Job> getJobsBySkill(@PathVariable Long skillId) {
        return service.getJobsBySkill(skillId);
    }

    // Search By Experience
    @GetMapping("/experience/{experience}")
    public List<Job> getJobsByExperience(@PathVariable Integer experience) {
        return service.getJobsByExperience(experience);
    }

    // Search By Qualification
    @GetMapping("/qualification/{qualification}")
    public List<Job> getJobsByQualification(@PathVariable String qualification) {
        return service.getJobsByQualification(qualification);
    }

    // Search By Company
    @GetMapping("/company/{companyId}")
    public List<Job> getJobsByCompany(@PathVariable Long companyId) {
        return service.getJobsByCompany(companyId);
    }

    // Get Open Jobs
    @GetMapping("/open")
    public List<Job> getOpenJobs() {
        return service.getOpenJobs();
    }

    // Search By Salary
    @GetMapping("/salary")
    public List<Job> getJobsBySalary(@RequestParam Double minSalary,
                                     @RequestParam Double maxSalary) {
        return service.getJobsBySalary(minSalary, maxSalary);
    }
}