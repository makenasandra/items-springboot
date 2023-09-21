package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.service.ItemService;
import com.example.itemsspringbootapp.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/items")
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

}
