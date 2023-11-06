package com.revs.unittesting.controller;

import com.revs.unittesting.model.Item;
import com.revs.unittesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-service")
    public Item getItemFromService() {
        return this.itemService.retriveItem();
    }

    @GetMapping("/items-from-db")
    public List<Item> getItemFromDB() {
        List<Item> items = this.itemService.getAllItems();
        return items;
    }

}
