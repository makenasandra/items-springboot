package com.example.itemsspringbootapp.repository;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //provides you with the CRUD methods
    Item getItemById(int id);
    List<Item> findByCategoryId(Long categoryId);
    List<Item> getByCategoryId(Long categoryId);
//    List<Item> findAllByTagId(Long id);
}
