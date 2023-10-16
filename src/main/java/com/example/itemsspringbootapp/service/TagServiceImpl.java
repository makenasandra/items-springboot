package com.example.itemsspringbootapp.service;

import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService{
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
}
