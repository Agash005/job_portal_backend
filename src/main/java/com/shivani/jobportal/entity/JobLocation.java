package com.shivani.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_locations")
public class JobLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String locationName;

    public JobLocation() {
    }

    public JobLocation(Long id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}