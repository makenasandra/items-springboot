package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;
    private Map<Integer, Item> itemMap = new HashMap<>();
    @Override
    public Item createItem(Item item) {
        itemMap.put(item.getId(), item);
        itemRepository.save(item);
        return item;
    }

    @Override
    public Item getItem(int itemId) {
        Item item = itemMap.get(itemId);
        if(item != null){
            return item;
        } else{
            return null;
        }
    }

    @Override
    public Item updateItem(Item item, int itemId) {
        if (itemMap.get(itemId) == null){
            return null;
        }
        itemMap.replace(itemId, item);
        return itemMap.get(itemId);
    }

    @Override
    public Item deleteItem(int itemId) {
        Item item = itemMap.get(itemId);
        if(item != null) {
            itemMap.remove(itemId);
            return item;
        } else {
            return null;
        }
    }
}
