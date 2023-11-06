package com.revs.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimpleController.class)
class SimpleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testHelloWorld_basicTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher status;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().string("Hello world!"))
                .andReturn();

        // assertEquals("Hello world!", result.getResponse().getContentAsString());
    }
}