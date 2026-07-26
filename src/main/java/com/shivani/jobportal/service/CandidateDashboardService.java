package com.shivani.jobportal.service;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.dto.CandidateDashboardResponse;
import com.shivani.jobportal.entity.CandidateProfile;
import com.shivani.jobportal.entity.User;
import com.shivani.jobportal.repository.CandidateProfileRepository;
import com.shivani.jobportal.repository.JobApplicationRepository;
import com.shivani.jobportal.repository.UserRepository;

@Service
public class CandidateDashboardService {

    private final UserRepository userRepository;
    private final JobApplicationRepository applicationRepository;
    private final CandidateProfileRepository profileRepository;

    public CandidateDashboardService(
            UserRepository userRepository,
            JobApplicationRepository applicationRepository,
            CandidateProfileRepository profileRepository) {

        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.profileRepository = profileRepository;
    }

    public CandidateDashboardResponse getDashboard(Long userId) {

        // Find candidate
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        // Count all applications
        long totalApplications =
                applicationRepository.countByUserId(userId);

        // Count APPLIED
        long applied =
                applicationRepository.countByUserIdAndStatus(
                        userId, "APPLIED");

        // Count SHORTLISTED
        long shortlisted =
                applicationRepository.countByUserIdAndStatus(
                        userId, "SHORTLISTED");

        // Count REJECTED
        long rejected =
                applicationRepository.countByUserIdAndStatus(
                        userId, "REJECTED");

        // Check candidate profile
        CandidateProfile profile =
                profileRepository.findByUserId(userId);

        boolean profileCreated = profile != null;

        return new CandidateDashboardResponse(
                user.getName(),
                totalApplications,
                applied,
                shortlisted,
                rejected,
                profileCreated
        );
    }
}