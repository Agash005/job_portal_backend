package com.shivani.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivani.jobportal.entity.JobCategory;
import com.shivani.jobportal.repository.JobCategoryRepository;

@Service
public class JobCategoryService {

    private final JobCategoryRepository repository;

    public JobCategoryService(JobCategoryRepository repository) {
        this.repository = repository;
    }

    // Create Category
    public JobCategory createCategory(JobCategory category) {

        JobCategory existingCategory =
                repository.findByCategoryName(category.getCategoryName())
                          .orElse(null);

        if (existingCategory != null) {
            return null;
        }

        return repository.save(category);
    }

    // Get All Categories
    public List<JobCategory> getAllCategories() {
        return repository.findAll();
    }

    // Get Category By ID
    public JobCategory getCategoryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Category
    public JobCategory updateCategory(Long id, JobCategory newCategory) {

        JobCategory existingCategory =
                repository.findById(id).orElse(null);

        if (existingCategory == null) {
            return null;
        }

        existingCategory.setCategoryName(newCategory.getCategoryName());

        return repository.save(existingCategory);
    }

    // Delete Category
    public boolean deleteCategory(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}