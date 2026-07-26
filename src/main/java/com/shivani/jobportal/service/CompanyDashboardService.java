package com.shivani.jobportal.service;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.dto.CompanyDashboardResponse;
import com.shivani.jobportal.entity.Company;
import com.shivani.jobportal.repository.CompanyRepository;
import com.shivani.jobportal.repository.JobApplicationRepository;
import com.shivani.jobportal.repository.JobRepository;

@Service
public class CompanyDashboardService {

    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    private final JobApplicationRepository applicationRepository;

    public CompanyDashboardService(
            CompanyRepository companyRepository,
            JobRepository jobRepository,
            JobApplicationRepository applicationRepository) {

        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
    }

    public CompanyDashboardResponse getDashboard(Long companyId) {

        // Find company
        Company company =
                companyRepository.findById(companyId).orElse(null);

        if (company == null) {
            return null;
        }

        // Total jobs posted by this company
        long totalJobs =
                jobRepository.countByCompanyId(companyId);

        // Open jobs
        long openJobs =
                jobRepository.countByCompanyIdAndStatus(
                        companyId, "OPEN");

        // Closed jobs
        long closedJobs =
                jobRepository.countByCompanyIdAndStatus(
                        companyId, "CLOSED");
        
        long totalApplications =
                applicationRepository.countByJobCompanyId(companyId);

        return new CompanyDashboardResponse(
                company.getCompanyName(),
                company.getStatus(),
                totalJobs,
                openJobs,
                closedJobs,
                totalApplications
        );
    }
}