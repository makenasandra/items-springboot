package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemController {

    private Map<Integer, Item> itemMap = new HashMap<>();

    private int nextItemId = 1;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        itemMap.put(nextItemId, item);
        nextItemId++;
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") int itemId){
        Item item = itemMap.get(itemId);
        if(item != null){
            return ResponseEntity.ok(item);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") int itemId, @RequestBody Item item){

        if (itemMap.get(itemId) == null){
            return ResponseEntity.notFound().build();
        }
        itemMap.replace(itemId, item);
        return ResponseEntity.ok("Item updated successfully: " + itemMap.get(itemId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem (@PathVariable("id") int itemId){
        Item item = itemMap.get(itemId);
        if(item != null) {
            itemMap.remove(itemId);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
