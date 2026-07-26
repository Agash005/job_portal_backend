package com.shivani.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.CandidateProfile;

public interface CandidateProfileRepository
        extends JpaRepository<CandidateProfile, Long> {

    CandidateProfile findByUserId(Long userId);
}