package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;

import com.example.itemsspringbootapp.service.ItemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@Tag(name = "Item API", description = "Perform CRUD operations on Item")
public class ItemController {
    ItemServiceImpl itemService;
    @Autowired
    public ItemController(ItemServiceImpl itemService){
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
       Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") int itemId){
        Item item = itemService.getItem(itemId);
        if(item != null){
            return ResponseEntity.ok(item);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") int itemId, @RequestBody Item item){

        Item updatedItem = itemService.updateItem(item, itemId);
        return ResponseEntity.ok("Item updated successfully: " + updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem (@PathVariable("id") int itemId){
        Item deletedItem = itemService.deleteItem(itemId);

        if(deletedItem != null) {
            return ResponseEntity.ok(deletedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/categories/item-list")
    public List<Item> getItemsByCategoryId(@RequestParam(name = "id", required = false) Long id){
        if(id != null){
            return itemService.getItemsByCategoryId(id);
        }else {
           return itemService.getAllItemsWithCategories();
        }
    }

    @GetMapping("/items-by-tag")
    @Operation(summary = "Retrieve all items associated with a specific tag. Accepts the tag's name as a parameter and returns a list of items associated with that tag.")
    public ResponseEntity<List<Item>> getItemsByTagName(@RequestParam(name = "tagName") String tagName){
        List<Item> itemList = itemService.getItemsByTagName(tagName);

        if(itemList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(itemList);
        }
    }
}
