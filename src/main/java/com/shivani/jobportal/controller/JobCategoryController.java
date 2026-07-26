package com.shivani.jobportal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.shivani.jobportal.entity.JobCategory;
import com.shivani.jobportal.service.JobCategoryService;

@RestController
@RequestMapping("/api/categories")
public class JobCategoryController {

    private final JobCategoryService service;

    public JobCategoryController(JobCategoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody JobCategory category) {

        JobCategory savedCategory = service.createCategory(category);

        if (savedCategory != null) {
            return "Category Created Successfully";
        }

        return "Category Already Exists";
    }

    @GetMapping("/all")
    public List<JobCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public JobCategory getCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public String updateCategory(
            @PathVariable Long id,
            @RequestBody JobCategory category) {

        JobCategory updatedCategory =
                service.updateCategory(id, category);

        if (updatedCategory != null) {
            return "Category Updated Successfully";
        }

        return "Category Not Found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {

        boolean deleted = service.deleteCategory(id);

        if (deleted) {
            return "Category Deleted Successfully";
        }

        return "Category Not Found";
    }
}	