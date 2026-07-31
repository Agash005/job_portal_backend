package com.shivani.jobportal.service;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.dto.AdminDashboardResponse;
import com.shivani.jobportal.repository.CompanyRepository;
import com.shivani.jobportal.repository.EmployeeRepository;
import com.shivani.jobportal.repository.JobApplicationRepository;
import com.shivani.jobportal.repository.JobRepository;
import com.shivani.jobportal.repository.UserRepository;

@Service
public class AdminDashboardService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final JobRepository jobRepository;
    private final JobApplicationRepository applicationRepository;
    private final EmployeeRepository employeeRepository;

    public AdminDashboardService(
            UserRepository userRepository,
            CompanyRepository companyRepository,
            JobRepository jobRepository,
            JobApplicationRepository applicationRepository,
            EmployeeRepository employeeRepository) {

        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
        this.employeeRepository = employeeRepository;
    }

    public AdminDashboardResponse getDashboard() {

        long totalCandidates =
                userRepository.countByRole("CANDIDATE");

        long totalCompanies =
                companyRepository.count();

        long totalJobs =
                jobRepository.count();

        long openJobs =
                jobRepository.findByStatus("OPEN").size();

        long totalApplications =
                applicationRepository.count();

        long totalEmployees =
                employeeRepository.count();

        return new AdminDashboardResponse(
                totalCandidates,
                totalCompanies,
                totalJobs,
                openJobs,
                totalApplications,
                totalEmployees
        );
    }
}