package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.JobSkill;
import com.shivani.jobportal.service.JobSkillService;

@RestController
@RequestMapping("/api/skills")
public class JobSkillController {

    private final JobSkillService service;

    public JobSkillController(JobSkillService service) {
        this.service = service;
    }

    // Create Skill
    @PostMapping("/create")
    public String createSkill(@RequestBody JobSkill skill) {

        JobSkill savedSkill = service.createSkill(skill);

        if (savedSkill != null) {
            return "Skill Created Successfully";
        }

        return "Skill Already Exists";
    }

    // Get All Skills
    @GetMapping("/all")
    public List<JobSkill> getAllSkills() {
        return service.getAllSkills();
    }

    // Get Skill By Id
    @GetMapping("/{id}")
    public JobSkill getSkillById(@PathVariable Long id) {
        return service.getSkillById(id);
    }

    // Update Skill
    @PutMapping("/update/{id}")
    public String updateSkill(@PathVariable Long id,
                              @RequestBody JobSkill skill) {

        JobSkill updatedSkill =
                service.updateSkill(id, skill);

        if (updatedSkill != null) {
            return "Skill Updated Successfully";
        }

        return "Skill Not Found";
    }

    // Delete Skill
    @DeleteMapping("/delete/{id}")
    public String deleteSkill(@PathVariable Long id) {

        boolean deleted = service.deleteSkill(id);

        if (deleted) {
            return "Skill Deleted Successfully";
        }

        return "Skill Not Found";
    }

}