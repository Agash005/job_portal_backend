package com.shivani.jobportal.dto;

public class CompanyDashboardResponse {

    private String companyName;
    private String status;
    private long totalJobs;
    private long openJobs;
    private long closedJobs;
    private long totalApplications;

    public CompanyDashboardResponse() {
    }

    public CompanyDashboardResponse(
            String companyName,
            String status,
            long totalJobs,
            long openJobs,
            long closedJobs,
            long totalApplications) {

        this.companyName = companyName;
        this.status = status;
        this.totalJobs = totalJobs;
        this.openJobs = openJobs;
        this.closedJobs = closedJobs;
        this.totalApplications = totalApplications;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public long getClosedJobs() {
        return closedJobs;
    }

    public void setClosedJobs(long closedJobs) {
        this.closedJobs = closedJobs;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }
}