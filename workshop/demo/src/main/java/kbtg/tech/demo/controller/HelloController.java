package kbtg.tech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kbtg.tech.demo.controller.response.HelloResponse;
import kbtg.tech.demo.service.MessageService;

@RestController
public class HelloController {
    
    private MessageService messageService;
    
    @Autowired
    public HelloController(MessageService messageService) {
        this.messageService = messageService;
    }
	
	@GetMapping("/hello/{name}")
	public HelloResponse 
	    sayHi(@PathVariable String name) {
	    String result = messageService.concat(name);
	    return new HelloResponse(result);
	}

}
