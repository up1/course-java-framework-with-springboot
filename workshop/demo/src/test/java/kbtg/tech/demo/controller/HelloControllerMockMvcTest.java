package kbtg.tech.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import kbtg.tech.demo.service.MessageService;

import static 
org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static 
org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerMockMvcTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private MessageService messageService;
    
    @Test
    public void success_with_correct_message() throws Exception {
        given(messageService.concat("somkiat"))
        .willReturn("Hello, somkiat"); 
        
        mockMvc.perform(get("/hello/somkiat"))
            .andExpect(
                    jsonPath("$.message")
                      .value("Hello, somkiat") 
                    );
    }
    
    @Test
    public void success_with_code_200() throws Exception {
        mockMvc.perform(get("/hello/somkiat"))
            .andExpect(status().isOk());
    }
    
    

}
