package com.example.app.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.app.model.Item;

@Repository
public class ItemRepository {
   
    private List<Item> items = Arrays.asList(
        new Item("Keyboard A", 12000.0),
        new Item("Keyboard B", 20000.0),
        new Item("Keyboard C", 35000.0),
        new Item("Mouse X", 12000.0),
        new Item("Mouse Y", 20000.0),
        new Item("Mouse Z", 35000.0)
    );

    public List<Item> findAll() {
        return items;
    }
}
