package com.example.itemsspringbootapp.exceptions;

//This custom exception allow you to clearly handle the scenarios where the specified item
// does not exist and provide meaningful error responses to the client.
public class ItemNotFoundException extends RuntimeException  {
    @Override
    public String getMessage() {
        return "No such Item found";
    }
}
