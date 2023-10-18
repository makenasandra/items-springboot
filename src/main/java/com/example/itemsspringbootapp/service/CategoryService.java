package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Category;

import java.util.List;

public interface CategoryService {
    void deleteCategory(Long id);

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category updateCategory(Long categoryId, Category category);

    Category getCategoryById(Long categoryId);
}
