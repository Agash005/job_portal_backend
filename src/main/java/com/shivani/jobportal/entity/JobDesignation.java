package com.shivani.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_designations")
public class JobDesignation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String designationName;

    public JobDesignation() {
    }

    public JobDesignation(Long id, String designationName) {
        this.id = id;
        this.designationName = designationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }
}