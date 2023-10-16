package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.repository.CategoryRepository;
import com.example.itemsspringbootapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category createCategory(Category category) {

        return  categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
