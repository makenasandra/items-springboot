package com.example.itemsspringbootapp.repository;

import com.example.itemsspringbootapp.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag getTagByName(String name);
//    List<Tag> getTagsByItemId(int itemId);
}
