package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.JobSkill;
import com.shivani.jobportal.repository.JobSkillRepository;

@Service
public class JobSkillService {

    private final JobSkillRepository repository;

    public JobSkillService(JobSkillRepository repository) {
        this.repository = repository;
    }

    // Create Skill
    public JobSkill createSkill(JobSkill skill) {

        JobSkill existingSkill =
                repository.findBySkillName(skill.getSkillName())
                          .orElse(null);

        if (existingSkill != null) {
            return null;
        }

        return repository.save(skill);
    }

    // Get All Skills
    public List<JobSkill> getAllSkills() {
        return repository.findAll();
    }

    // Get Skill By Id
    public JobSkill getSkillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Skill
    public JobSkill updateSkill(Long id, JobSkill newSkill) {

        JobSkill existingSkill =
                repository.findById(id).orElse(null);

        if (existingSkill == null) {
            return null;
        }

        existingSkill.setSkillName(newSkill.getSkillName());

        return repository.save(existingSkill);
    }

    // Delete Skill
    public boolean deleteSkill(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}