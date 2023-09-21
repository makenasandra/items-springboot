package com.example.itemsspringbootapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Item {
    @Id
    private int id;
    private String name;
    private String status;
    private String description;
    private Timestamp createdOn;

    public Item(){};
}
