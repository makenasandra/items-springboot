package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;

import java.util.List;
import java.util.Set;

public interface TagService {
    List<Tag> getTagsByItemId(int itemId);
    Tag createTag(Tag tag);

    List<Tag> getAllTags();

    Tag getTagByName(String tagName);

    Tag addItemsToTag(String tagName, Set<Item> itemsSet);
}
