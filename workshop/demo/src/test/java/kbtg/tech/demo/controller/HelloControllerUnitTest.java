package kbtg.tech.demo.controller;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.MockitoAnnotations.initMocks;

import kbtg.tech.demo.controller.response.HelloResponse;
import kbtg.tech.demo.service.MessageService;

public class HelloControllerUnitTest {
    
    private HelloController helloController;
    
    @Mock private MessageService messageService;
    
    @Before
    public void initial() {
       MockitoAnnotations.initMocks(this);
       helloController = new HelloController(messageService);
    }
    
    @Test
    public void test() {
        given(messageService.concat("somkiat"))
        .willReturn("Hello, somkiat"); 
        
        // TODO
        HelloResponse response 
            = helloController.sayHi("somkiat");
        assertEquals("Hello, somkiat", response.getMessage());
    }

}
