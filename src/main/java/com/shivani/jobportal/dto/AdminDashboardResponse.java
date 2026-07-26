package com.shivani.jobportal.dto;

public class AdminDashboardResponse {

    private long totalCandidates;
    private long totalCompanies;
    private long totalJobs;
    private long openJobs;
    private long totalApplications;
    private long totalEmployees;

    public AdminDashboardResponse() {
    }

    public AdminDashboardResponse(long totalCandidates,
                                  long totalCompanies,
                                  long totalJobs,
                                  long openJobs,
                                  long totalApplications,
                                  long totalEmployees) {

        this.totalCandidates = totalCandidates;
        this.totalCompanies = totalCompanies;
        this.totalJobs = totalJobs;
        this.openJobs = openJobs;
        this.totalApplications = totalApplications;
        this.totalEmployees = totalEmployees; 
    }

    public long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public long getTotalCompanies() {
        return totalCompanies;
    }

    public void setTotalCompanies(long totalCompanies) {
        this.totalCompanies = totalCompanies;
    }

    public long getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public long getOpenJobs() {
        return openJobs;
    }

    public void setOpenJobs(long openJobs) {
        this.openJobs = openJobs;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
    
    public long getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(long totalEmployees) {
        this.totalEmployees = totalEmployees;
    }
}