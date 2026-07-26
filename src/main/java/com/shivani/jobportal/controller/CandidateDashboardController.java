package com.shivani.jobportal.controller;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.dto.CandidateDashboardResponse;
import com.shivani.jobportal.service.CandidateDashboardService;

@RestController
@RequestMapping("/api/candidates")
public class CandidateDashboardController {

    private final CandidateDashboardService dashboardService;

    public CandidateDashboardController(
            CandidateDashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/{userId}/dashboard")
    public CandidateDashboardResponse getDashboard(
            @PathVariable Long userId) {

        return dashboardService.getDashboard(userId);
    }
}