package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.jobportal.entity.Company;
import com.shivani.jobportal.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/register")
    public String registerCompany(@RequestBody Company company) {

        if (companyService.emailExists(company.getEmail())) {
            return "Company email already registered";
        }

        companyService.registerCompany(company);

        return "Company registered successfully. Waiting for admin approval";
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/pending")
    public List<Company> getPendingCompanies() {
        return companyService.getPendingCompanies();
    }
    
    @GetMapping("/approved")
    public List<Company> getApprovedCompanies(){
    	return companyService.getApprovedCompanies();
    }

    @PutMapping("/approve/{id}")
    public String approveCompany(@PathVariable Long id) {

        Company company = companyService.approveCompany(id);

        if (company != null) {
            return "Company approved successfully";
        }

        return "Company not found";
    }
}	