package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.Job;
import com.shivani.jobportal.entity.JobApplication;
import com.shivani.jobportal.entity.User;
import com.shivani.jobportal.repository.JobApplicationRepository;
import com.shivani.jobportal.repository.JobRepository;
import com.shivani.jobportal.repository.UserRepository;

@Service
public class JobApplicationService {

    private final JobApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public JobApplicationService(
            JobApplicationRepository applicationRepository,
            UserRepository userRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    public JobApplication applyForJob(Long userId, Long jobId) {

        User user = userRepository.findById(userId).orElse(null);
        Job job = jobRepository.findById(jobId).orElse(null);

        if (user == null || job == null) {
            return null;
        }

        if (!job.getStatus().equals("OPEN")) {
            return null;
        }

        if (applicationRepository.existsByUserIdAndJobId(userId, jobId)) {
            return null;
        }

        JobApplication application = new JobApplication();

        application.setUser(user);
        application.setJob(job);
        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }

    public List<JobApplication> getApplicationsByUser(Long userId) {
        return applicationRepository.findByUserId(userId);
    }

    public List<JobApplication> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }
    
    public JobApplication updateStatus(Long applicationId, String status) {

        JobApplication application =
                applicationRepository.findById(applicationId).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus(status);

        return applicationRepository.save(application);
    }
    
    public List<JobApplication> getApplicationsByCompany(Long companyId) {
        return applicationRepository.findByJobCompanyId(companyId);
    }
    
}