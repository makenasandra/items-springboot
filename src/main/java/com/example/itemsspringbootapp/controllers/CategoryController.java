package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @PostMapping()
    public Category createCategory(Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCategory(@RequestParam(value = "categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
}
