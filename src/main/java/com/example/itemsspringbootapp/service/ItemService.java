package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Item;

public interface ItemService {
    Item createItem(Item item);
    Item getItem(int itemId);
    Item updateItem(Item item, int itemId);
    Item deleteItem(int itemId);
}
