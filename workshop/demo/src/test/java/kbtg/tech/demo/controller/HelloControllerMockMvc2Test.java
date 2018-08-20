package kbtg.tech.demo.controller;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import kbtg.tech.demo.controller.response.HelloResponse;
import kbtg.tech.demo.service.MessageService;

import static 
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static java.lang.System.out;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerMockMvc2Test {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private MessageService messageService;
    
    private JacksonTester<HelloResponse> tester;
    
    @Before
    public void initial() {
        JacksonTester.initFields(this, new ObjectMapper());
        given(messageService.concat("somkiat"))
           .willReturn("Hello, somkiat");
    }
    
    @Test
    public void test() throws Exception {
        MockHttpServletResponse response 
           = mockMvc.perform(get("/hello/somkiat"))
             .andReturn().getResponse();  
        
        String expected = tester.write(
                new HelloResponse("Hello, somkiat")).getJson();
        
        assertEquals(expected, response.getContentAsString());
    }
    
    @Test
    
    public void test2() throws Exception {
        MockHttpServletResponse response 
           = mockMvc.perform(get("/hello/somkiat"))
             .andReturn().getResponse();
        
        String expected 
        = tester.write(new HelloResponse("Hello, somkiat")).getJson();
        
        assertEquals(expected, response.getContentAsString());
    }

}
