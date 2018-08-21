package kbtg.tech.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kbtg.tech.demo.repository.Message;
import kbtg.tech.demo.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public String getNameById(int id) {
        Optional<Message> message 
           = messageRepository.findById(id);
        if(message.isPresent()) {
            return "Hello, " + message.get().getData();
        }
        return "Not found";
    }
    
    public String concat(String name) {
        return "Hello, " + name;
    }

    public void setRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

}

