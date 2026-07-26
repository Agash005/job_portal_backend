package com.shivani.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.jobportal.dto.CompanyDashboardResponse;
import com.shivani.jobportal.service.CompanyDashboardService;

@RestController
@RequestMapping("/api/companies")
public class CompanyDashboardController {

    private final CompanyDashboardService dashboardService;

    public CompanyDashboardController(
            CompanyDashboardService dashboardService) {

        this.dashboardService = dashboardService;
    }

    @GetMapping("/{companyId}/dashboard")
    public CompanyDashboardResponse getDashboard(
            @PathVariable Long companyId) {

        return dashboardService.getDashboard(companyId);
    }
}