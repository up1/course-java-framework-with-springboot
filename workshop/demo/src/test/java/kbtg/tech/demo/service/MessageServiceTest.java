package kbtg.tech.demo.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import kbtg.tech.demo.repository.Message;
import kbtg.tech.demo.repository.MessageRepository;

public class MessageServiceTest {
    
    private MessageService messageService;
    
    @Mock
    private MessageRepository messageRepository;
    
    @Before
    public void initial() {
        MockitoAnnotations.initMocks(this);
        messageService = new MessageService();
        messageService.setRepository(messageRepository);
    }
    
    @Test
    public void success() {
        Message stubMessage = new Message();
        stubMessage.setData("somkiat");
        
        given(messageRepository.findById(1))
        .willReturn(Optional.of(stubMessage)); 
        
        String actualResult 
             = messageService.getNameById(1);
        assertEquals("Hello, somkiat", actualResult);
    }
    
    @Test
    public void not_found() {
        given(messageRepository.findById(1))
        .willReturn(Optional.empty()); 
        
        String actualResult 
             = messageService.getNameById(1);
        assertEquals("Not found", actualResult);
    }

}
