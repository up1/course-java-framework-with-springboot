package kbtg.tech.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import kbtg.tech.demo.controller.response.HelloResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment 
		= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerSpringTest {
	
	@Autowired
	private TestRestTemplate rest;

	@Test
	public void test() {
		HelloResponse response  
		     = rest.getForObject("/hello/somkiat", 
		    		             HelloResponse.class);
		assertEquals("Hello, somkiat", 
				     response.getMessage());
	}

}
