package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.repository.CategoryRepository;
import com.example.itemsspringbootapp.repository.ItemRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;

    CategoryRepository categoryRepository;
    @Autowired
    public ItemServiceImpl (ItemRepository itemRepository, CategoryRepository categoryRepository){
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Item createItem(Item item) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime toCurrentTimeZOne = currentDateTime.atZone(ZoneId.of("Africa/Addis_Ababa")).toLocalDateTime();
        item.setCreatedOn(Timestamp.valueOf(toCurrentTimeZOne));
        itemRepository.save(item);
        return item;
    }

    @Override
    public Item getItem(int itemId) {
        Item item = itemRepository.getItemById(itemId);
        if(item != null){
            return item;
        } else{
            return null;
        }
    }

    @Override
    public Item updateItem(Item item, int itemId) {
        if (itemRepository.getItemById(itemId) == null){
            return null;
        }
        item.setCreatedOn(Timestamp.valueOf(LocalDateTime.now().atZone(ZoneId.of("Africa/Nairobi")).toLocalDateTime()));
        itemRepository.save(item);
        return itemRepository.getItemById(itemId);
    }

    @Override
    public Item deleteItem(int itemId) {
        Item item = itemRepository.getItemById(itemId);
        if(item != null) {
            itemRepository.deleteById(itemId);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getItemsByCategoryId(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }
}
