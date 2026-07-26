package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.Company;
import com.shivani.jobportal.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company registerCompany(Company company) {

        company.setStatus("PENDING");

        return companyRepository.save(company);
    }

    public boolean emailExists(String email) {

        Company company = companyRepository.findByEmail(email);

        return company != null;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Company> getPendingCompanies() {
        return companyRepository.findByStatus("PENDING");
    }
    
    public List<Company>getApprovedCompanies(){
    	return companyRepository.findByStatus("Approved");
    }

    public Company approveCompany(Long id) {

        Company company = companyRepository.findById(id).orElse(null);

        if (company != null) {
            company.setStatus("APPROVED");
            return companyRepository.save(company);
        }

        return null;
    }
}