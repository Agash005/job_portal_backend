package com.shivani.jobportal.dto;

public class CandidateDashboardResponse {

    private String candidateName;
    private long totalApplications;
    private long applied;
    private long shortlisted;
    private long rejected;
    private boolean profileCreated;

    public CandidateDashboardResponse() {
    }

    public CandidateDashboardResponse(
            String candidateName,
            long totalApplications,
            long applied,
            long shortlisted,
            long rejected,
            boolean profileCreated) {

        this.candidateName = candidateName;
        this.totalApplications = totalApplications;
        this.applied = applied;
        this.shortlisted = shortlisted;
        this.rejected = rejected;
        this.profileCreated = profileCreated;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public long getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(long totalApplications) {
        this.totalApplications = totalApplications;
    }

    public long getApplied() {
        return applied;
    }

    public void setApplied(long applied) {
        this.applied = applied;
    }

    public long getShortlisted() {
        return shortlisted;
    }

    public void setShortlisted(long shortlisted) {
        this.shortlisted = shortlisted;
    }

    public long getRejected() {
        return rejected;
    }

    public void setRejected(long rejected) {
        this.rejected = rejected;
    }

    public boolean isProfileCreated() {
        return profileCreated;
    }

    public void setProfileCreated(boolean profileCreated) {
        this.profileCreated = profileCreated;
    }
}