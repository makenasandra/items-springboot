package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.repository.CategoryRepository;
import com.example.itemsspringbootapp.repository.ItemRepository;
import com.example.itemsspringbootapp.repository.TagRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;

    CategoryRepository categoryRepository;

    @Autowired
    TagRepository tagRepository;
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
        return itemRepository.getByCategoryId(categoryId);
    }

    @Override
    public List<Item> getAllItemsWithCategories() {
        List<Item> itemList = itemRepository.findAll();
        List<Item> listWithCategories = new ArrayList<>();
        for (Item item:
             itemList) {
            if(item.getCategory().getName() != null){
                listWithCategories.add(item);
            }
        }
        return listWithCategories;
    }

    @Override
    public List<Item> getItemsByTagName(String tagName) {
        Tag tag = tagRepository.getTagByName(tagName);
        if(tag != null) {
            Long tagId = tag.getId();
//            return itemRepository.findAllByTagId(tagId);
            return null;
        } else{
            return null;
        }
    }

}
