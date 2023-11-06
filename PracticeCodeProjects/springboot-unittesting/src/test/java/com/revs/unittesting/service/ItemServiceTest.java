package com.revs.unittesting.service;

import com.revs.unittesting.model.Item;
import com.revs.unittesting.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    void testRetriveItem() {
        Item item = itemService.retriveItem();
        assertEquals(2, item.getId());
        assertEquals("Bell", item.getName());
        assertInstanceOf(Item.class, item);
    }

    @Test
    void testGetAllItems() {
        when(itemRepository.findAll())
                .thenReturn(Arrays.asList(new Item(1, "item1", 12, 5),
                        new Item(2, "item2", 4, 5)));

        List<Item> allItems = itemService.getAllItems();
        assertEquals(60, allItems.get(0).getValue());
        assertEquals(20, allItems.get(1).getValue());
    }
}