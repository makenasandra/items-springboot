package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagsByItemId(int itemId);
    Tag createTag(Tag tag);

    List<Tag> getAllTags();
}
