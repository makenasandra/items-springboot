package com.example.itemsspringbootapp.repository;

import com.example.itemsspringbootapp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //provides you with the CRUD methods
}
