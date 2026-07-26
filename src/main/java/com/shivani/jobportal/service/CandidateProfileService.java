package com.shivani.jobportal.service;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.CandidateProfile;
import com.shivani.jobportal.entity.User;
import com.shivani.jobportal.repository.CandidateProfileRepository;
import com.shivani.jobportal.repository.UserRepository;

@Service
public class CandidateProfileService {

    private final CandidateProfileRepository profileRepository;
    private final UserRepository userRepository;

    public CandidateProfileService(
            CandidateProfileRepository profileRepository,
            UserRepository userRepository) {

        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    // Create Candidate Profile
    public CandidateProfile createProfile(
            Long userId, CandidateProfile profile) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        CandidateProfile existingProfile =
                profileRepository.findByUserId(userId);

        if (existingProfile != null) {
            return null;
        }

        profile.setUser(user);

        return profileRepository.save(profile);
    }

    // View Candidate Profile
    public CandidateProfile getProfile(Long userId) {
        return profileRepository.findByUserId(userId);
    }

    // Update Candidate Profile
    public CandidateProfile updateProfile(
            Long userId, CandidateProfile newProfile) {

        CandidateProfile existingProfile =
                profileRepository.findByUserId(userId);

        if (existingProfile == null) {
            return null;
        }

        existingProfile.setQualification(newProfile.getQualification());
        existingProfile.setSkills(newProfile.getSkills());
        existingProfile.setExperience(newProfile.getExperience());
        existingProfile.setLocation(newProfile.getLocation());
        existingProfile.setResume(newProfile.getResume());

        return profileRepository.save(existingProfile);
    }
}