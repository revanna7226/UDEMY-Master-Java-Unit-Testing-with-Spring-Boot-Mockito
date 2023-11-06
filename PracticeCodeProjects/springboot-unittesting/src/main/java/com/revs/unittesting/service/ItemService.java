package com.revs.unittesting.service;

import com.revs.unittesting.model.Item;
import com.revs.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retriveItem() {
        return new Item(2, "Bell", 23, 1000);
    }

    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        items.stream().map(item -> {
            item.setValue(item.getPrice() * item.getQuantity());
            return item;
        }).collect(Collectors.toList());
        return items;
    }
}
