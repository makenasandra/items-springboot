package com.example.itemsspringbootapp.controllers;

import com.example.itemsspringbootapp.models.Tag;
import com.example.itemsspringbootapp.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TagService tagService;

    @Test
    // This test case checks the behavior of the endpoint when tags are associated with
    // the specified item. We mock the TagService to return a list of tags associated with
    // the item with ID 1 and expect the response status to be OK (200). We also verify the
    // content of the JSON response, ensuring that it contains the expected tags.
    public void testGetTagsByItem_WithTags() throws Exception {
        // Mock the service to return tags associated with the item
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Tag1"));
        tags.add(new Tag("Tag2"));
        when(tagService.getTagsByItemId(1)).thenReturn(tags);

        mockMvc.perform(get("/api/tags/tags-by-item")
                        .param("itemId", "1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Tag1")))
                .andExpect((ResultMatcher) jsonPath("$[1].name", is("Tag2")));
    }

    @Test
    //This test case checks the behavior when the item has no associated tags.
    // We mock the service to return an empty list,
    // and we expect the response status to be NOT FOUND (404).
    public void testGetTagsByItem_WithNoTags() throws Exception {
        // Mock the service to return an empty list when the item has no associated tags
        when(tagService.getTagsByItemId(21)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/tags/tags-by-item")
                        .param("itemId", "2"))
                .andExpect(status().isNotFound());
    }
}
