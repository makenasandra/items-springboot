package com.example.itemsspringbootapp.repository;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
