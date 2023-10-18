package com.example.itemsspringbootapp.controllers;


import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.service.TagServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tags")
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag API", description = "Perform CRUD operations on Item")
public class TagController {
    @Autowired
    private TagServiceImpl tagService;

    @GetMapping("/tags-by-item")
    @Operation(summary = "Get tags that belong to item by providing item id", method = "GET")
    public ResponseEntity<List<Tag>> getTagsByItem(@RequestParam("itemId") int itemId) {
        List<Tag> tags = tagService.getTagsByItemId(itemId);
        if (tags.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tags);
        }
    }

    @GetMapping("/tag-by-name")
    @Operation(summary = "Get tag by name", method = "GET")
    public ResponseEntity<Tag> getTagByName(@RequestParam("tagName") String tagName) {
        Tag tag = tagService.getTagByName(tagName);
        if (tag == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(tag);
        }
    }

    @PostMapping ("/add-item")
    @Operation(summary = "Add item(s) to tag")
    public ResponseEntity<?> addItemsToTag(@RequestParam("tagName") String tagName, @RequestBody Set<Item> itemsList) {
        Tag tag = tagService.addItemsToTag(tagName, itemsList);
        if (tag == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tag not found");
        } else {
            return ResponseEntity.ok(tag);
        }
    }

    @PostMapping
    @Operation(summary = "Create a tag", method = "POST")
    public  ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        Tag createdTag = tagService.createTag(tag);
        return ResponseEntity.ok(createdTag);
    }

    @GetMapping
    @Operation(summary = "Get all tags", method = "GET")
    public ResponseEntity<List<Tag>> getAllTags(){
        return ResponseEntity.ok(tagService.getAllTags());
    }
}

