package com.example.itemsspringbootapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "tags")
    private Set<Item> items = new HashSet<>();

    // Constructors, getters, and setters

    public Tag() {
        // Default constructor
    }

    public Tag(String name) {
        this.name = name;
    }
}
