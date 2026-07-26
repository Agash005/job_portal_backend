package com.shivani.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.jobportal.entity.JobSkill;

public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {

    Optional<JobSkill> findBySkillName(String skillName);

}