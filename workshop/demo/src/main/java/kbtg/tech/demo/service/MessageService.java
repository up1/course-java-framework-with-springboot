package kbtg.tech.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    public String concat(String name) {
        return "Hello, " + name;
    }

}

