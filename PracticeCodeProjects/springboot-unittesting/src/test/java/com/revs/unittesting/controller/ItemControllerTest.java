package com.revs.unittesting.controller;

import com.revs.unittesting.model.Item;
import com.revs.unittesting.service.ItemService;
import org.apache.coyote.Request;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemService itemService;

    @Test
    void getItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/item").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"name\":\"Ball\",\"id\":1,\"price\":10,\"quantity\":100}"));
    }

    @Test
    void getItemFromService() throws Exception {
        when(itemService.retriveItem()).thenReturn(new Item(12, "Beer", 56, 452));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-db").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Beer\",\"id\":12,\"price\":56,\"quantity\":452}"));

    }

    @Test
    public void getItemFromDB() throws Exception {
        when(itemService.getAllItems()).thenReturn(
                Arrays.asList(new Item(1, "item1", 10, 20),
                              new Item(2, "item2", 29, 20)));

        RequestBuilder request = MockMvcRequestBuilders.get("/items-from-db").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1, name:item1,price:10,quantity:20}, {id:2, name:item2,price:29,quantity:20}]"));
    }

    /*
    EXAMPLE FOR POST METHOD TEST
     */
    @Test
    public void postCallTest_Example() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
                        "/items")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")
                .contentType (MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(header()
                        .string("location",
                                CoreMatchers.containsString("/item/")))
                .andReturn();
    }
}