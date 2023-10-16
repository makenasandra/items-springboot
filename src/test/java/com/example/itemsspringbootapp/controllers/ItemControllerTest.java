package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Category;
import com.example.itemsspringbootapp.models.Item;
import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.*;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;


    @Test
    void createItem() {
    }

    @Test
    void getItem() {
    }

    @Test
    void updateItem() {
    }

    @Test
    void deleteItem() {
    }

    @Test
    void getAllCategories() {
    }

    @Test
    void createCategory() {
    }

    @Test
    void getItemsByCategoryId() {
    }

    @Test
    //This test case checks the behavior of the endpoint when items are associated with the specified tag.
    // We mock the ItemService to return a list of items associated with "Tag1" and expect the response status to be OK (200).
    // We also verify the content of the JSON response, ensuring that it contains the expected items.
    public void testGetItemsByTag_WithItems() throws Exception {
        // Mock the service to return items associated with the tag
        Tag tag = new Tag();
        tag.setId(1L);
        tag.setName("Tag1");
        Tag tag1 = new Tag();
        tag.setId(2L);
        tag.setName("Tag2");
        Set<Tag> tagSet = Set.of(tag, tag1);

        Item item1 = new Item();
        item1.setId(1);
        item1.setName("Item1");
        item1.setCategory(new Category());
        item1.setTagSet(tagSet);

        Item item2 = new Item();
        item2.setId(2);
        item1.setName("Item2");
        item1.setCategory(new Category());
        item1.setTagSet(tagSet);

        List<Item> items = List.of(item1, item2);

        when(itemService.getItemsByTagName("Tag1")).thenReturn(items);

        mockMvc.perform(get("/items/items-by-tag")
                        .param("tagName", "Tag1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Item1")))
                .andExpect((ResultMatcher) jsonPath("$[1].name", is("Item2")));

    }

    @Test
    //This test case checks the behavior when no items are associated with the specified tag ("NonExistentTag").
    // We mock the service to return an empty list, and we expect the response status to be NOT FOUND (404).
    public void testGetItemsByTag_WithNoItems() throws Exception {
        // Mock the service to return an empty list when no items are associated with the tag
        when(itemService.getItemsByTagName("NonExistentTag")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/items/items-by-tag")
                        .param("tagName", "NonExistentTag"))
                .andExpect(status().isNotFound());
    }
}



