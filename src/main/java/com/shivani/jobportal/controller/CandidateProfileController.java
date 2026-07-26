package com.shivani.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.jobportal.entity.CandidateProfile;
import com.shivani.jobportal.service.CandidateProfileService;

@RestController
@RequestMapping("/api/profiles")
public class CandidateProfileController {

    private final CandidateProfileService profileService;

    public CandidateProfileController(
            CandidateProfileService profileService) {

        this.profileService = profileService;
    }

    // Create Profile
    @PostMapping("/create/{userId}")
    public String createProfile(
            @PathVariable Long userId,
            @RequestBody CandidateProfile profile) {

        CandidateProfile savedProfile =
                profileService.createProfile(userId, profile);

        if (savedProfile != null) {
            return "Profile created successfully";
        }

        return "User not found or profile already exists";
    }

    // View Profile
    @GetMapping("/{userId}")
    public CandidateProfile getProfile(
            @PathVariable Long userId) {

        return profileService.getProfile(userId);
    }

    // Update Profile
    @PutMapping("/update/{userId}")
    public String updateProfile(
            @PathVariable Long userId,
            @RequestBody CandidateProfile profile) {

        CandidateProfile updatedProfile =
                profileService.updateProfile(userId, profile);

        if (updatedProfile != null) {
            return "Profile updated successfully";
        }

        return "Profile not found";
    }
}