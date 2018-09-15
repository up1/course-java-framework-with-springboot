package com.lotto.lotto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotto.lotto.controller.response.AccountResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerSpringBootMockTest {

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<AccountResponse> jsonTester;

    @Test
    public void getById() throws Exception {

        JacksonTester.initFields(this, new ObjectMapper());

        MockHttpServletResponse response
                = mockMvc.perform(
                get("/account/1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertEquals("Status should 200", HttpStatus.OK.value(), response.getStatus());

        AccountResponse expected
                = new AccountResponse("user", "pass", 1000);
        assertEquals(jsonTester.write(expected).getJson(),
                response.getContentAsString());
    }
}