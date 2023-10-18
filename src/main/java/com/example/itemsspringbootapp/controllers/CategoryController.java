package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.service.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
@Tag(name = "Category API", description = "Perform CRUD operations on Category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @PostMapping()
    @Operation(summary = "Create a new category", method = "POST")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/all-categories")
    @Operation(summary = "Get all categories", method = "GET")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping()
    @Operation(summary = "Get a category by id", method = "GET")
    public Category getCategoryById(@RequestParam(value = "categoryId") Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping
    @Operation(summary = "Update a category", method = "PUT")
    public Category updateCategory(@RequestParam(value = "categoryId") Long categoryId, @RequestBody Category category){
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping
    @Operation(summary = "Delete a category by id", method = "DELETE")
    public ResponseEntity<?> deleteCategory(@RequestParam(value = "categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
