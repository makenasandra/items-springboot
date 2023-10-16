package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item getItem(int itemId);
    Item updateItem(Item item, int itemId);
    Item deleteItem(int itemId);

    List<Item> getItemsByCategoryId(Long categoryId);

    List<Item> getAllItemsWithCategories();

    List<Item> getItemsByTagName(String tagName);
}
