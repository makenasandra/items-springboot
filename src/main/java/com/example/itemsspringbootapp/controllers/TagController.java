package com.example.itemsspringbootapp.controllers;


import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.service.TagService;
import com.example.itemsspringbootapp.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagServiceImpl tagService;

    @GetMapping("/tags-by-item")
    public ResponseEntity<List<Tag>> getTagsByItem(@RequestParam("itemId") int itemId) {
        List<Tag> tags = tagService.getTagsByItemId(itemId);
        if (tags.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tags);
        }
    }

    @PostMapping
    public  ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        Tag createdTag = tagService.createTag(tag);
        return ResponseEntity.ok(createdTag);
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags(){
        return ResponseEntity.ok(tagService.getAllTags());
    }
}

