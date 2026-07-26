package com.shivani.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private JobCategory category;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private JobDesignation designation;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private JobLocation location;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private JobSkill skill;

    private Double salary;
    private Integer experience;
    private String qualification;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JobCategory getCategory() {
        return category;
    }

    public void setCategory(JobCategory category) {
        this.category = category;
    }

    public JobDesignation getDesignation() {
        return designation;
    }

    public void setDesignation(JobDesignation designation) {
        this.designation = designation;
    }

    public JobLocation getLocation() {
        return location;
    }

    public void setLocation(JobLocation location) {
        this.location = location;
    }

    public JobSkill getSkill() {
        return skill;
    }

    public void setSkill(JobSkill skill) {
        this.skill = skill;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}