package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * The type Tag service.
 */
@Service
public class TagServiceImpl implements TagService{
    /**
     * The Tag repository.
     */
    @Autowired
    TagRepository tagRepository;
    @Override
    public List<Tag> getTagsByItemId(int itemId) {
        return null;
//        return tagRepository.getTagsByItemId(itemId);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    /**
     * @param tagName
     * @return
     */
    @Override
    public Tag getTagByName(String tagName) {
        return tagRepository.getTagByName(tagName);
    }

    /**
     * @param tagName
     * @param items
     * @return tag
     */
    @Override
    public Tag addItemsToTag(String tagName, Set<Item> items) {
        Tag tag = tagRepository.getTagByName(tagName);
        Set<Item> itemSet=tag.getItems();
        items.addAll(itemSet);
        tag.setItems(items);
        return tagRepository.getTagByName(tagName);
    }
}
