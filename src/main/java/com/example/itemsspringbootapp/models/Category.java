package com.example.itemsspringbootapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Long created_by;
    private Timestamp created_on;
    private Long updated_by;
    private Timestamp updated_on;

    public Category(){}

}
