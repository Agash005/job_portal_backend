package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.Company;
import com.shivani.jobportal.entity.Job;
import com.shivani.jobportal.entity.JobCategory;
import com.shivani.jobportal.entity.JobDesignation;
import com.shivani.jobportal.entity.JobLocation;
import com.shivani.jobportal.entity.JobSkill;
import com.shivani.jobportal.repository.CompanyRepository;
import com.shivani.jobportal.repository.JobCategoryRepository;
import com.shivani.jobportal.repository.JobDesignationRepository;
import com.shivani.jobportal.repository.JobLocationRepository;
import com.shivani.jobportal.repository.JobRepository;
import com.shivani.jobportal.repository.JobSkillRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final JobCategoryRepository categoryRepository;
    private final JobDesignationRepository designationRepository;
    private final JobLocationRepository locationRepository;
    private final JobSkillRepository skillRepository;

    public JobService(JobRepository jobRepository,
                      CompanyRepository companyRepository,
                      JobCategoryRepository categoryRepository,
                      JobDesignationRepository designationRepository,
                      JobLocationRepository locationRepository,
                      JobSkillRepository skillRepository) {

        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
        this.designationRepository = designationRepository;
        this.locationRepository = locationRepository;
        this.skillRepository = skillRepository;
    }

    // Create Job
    public Job createJob(Long companyId,
                         Long categoryId,
                         Long designationId,
                         Long locationId,
                         Long skillId,
                         Job job) {

        Company company = companyRepository.findById(companyId).orElse(null);
        JobCategory category = categoryRepository.findById(categoryId).orElse(null);
        JobDesignation designation = designationRepository.findById(designationId).orElse(null);
        JobLocation location = locationRepository.findById(locationId).orElse(null);
        JobSkill skill = skillRepository.findById(skillId).orElse(null);

        if (company == null || category == null || designation == null
                || location == null || skill == null) {
            return null;
        }

        job.setCompany(company);
        job.setCategory(category);
        job.setDesignation(designation);
        job.setLocation(location);
        job.setSkill(skill);
        job.setStatus("OPEN");

        return jobRepository.save(job);
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By Id
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    // Update Job
    public Job updateJob(Long id, Job newJob) {

        Job existingJob = jobRepository.findById(id).orElse(null);

        if (existingJob == null) {
            return null;
        }

        existingJob.setTitle(newJob.getTitle());
        existingJob.setSalary(newJob.getSalary());
        existingJob.setExperience(newJob.getExperience());
        existingJob.setQualification(newJob.getQualification());
        existingJob.setDescription(newJob.getDescription());

        return jobRepository.save(existingJob);
    }

    // Delete Job
    public boolean deleteJob(Long id) {

        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }

        return false;
    }

    // Close Job
    public Job closeJob(Long id) {

        Job job = jobRepository.findById(id).orElse(null);

        if (job == null) {
            return null;
        }

        job.setStatus("CLOSED");

        return jobRepository.save(job);
    }

    // Search By Category
    public List<Job> getJobsByCategory(Long categoryId) {
        return jobRepository.findByCategoryId(categoryId);
    }

    // Search By Designation
    public List<Job> getJobsByDesignation(Long designationId) {
        return jobRepository.findByDesignationId(designationId);
    }

    // Search By Location
    public List<Job> getJobsByLocation(Long locationId) {
        return jobRepository.findByLocationId(locationId);
    }

    // Search By Skill
    public List<Job> getJobsBySkill(Long skillId) {
        return jobRepository.findBySkillId(skillId);
    }

    // Search By Experience
    public List<Job> getJobsByExperience(Integer experience) {
        return jobRepository.findByExperience(experience);
    }

    // Search By Qualification
    public List<Job> getJobsByQualification(String qualification) {
        return jobRepository.findByQualification(qualification);
    }

    // Search By Company
    public List<Job> getJobsByCompany(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    // Get Open Jobs
    public List<Job> getOpenJobs() {
        return jobRepository.findByStatus("OPEN");
    }

    // Search By Salary Range
    public List<Job> getJobsBySalary(Double minSalary, Double maxSalary) {
        return jobRepository.findBySalaryBetween(minSalary, maxSalary);
    }

}