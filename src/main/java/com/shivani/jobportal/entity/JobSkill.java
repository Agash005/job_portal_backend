package com.shivani.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_skills")
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String skillName;

    public JobSkill() {
    }

    public JobSkill(Long id, String skillName) {
        this.id = id;
        this.skillName = skillName;
    }

    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}