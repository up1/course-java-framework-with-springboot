package kbtg.tech.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kbtg.tech.demo.repository.Message;
import kbtg.tech.demo.repository.MessageRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); 
	}
	
	@Bean
	public CommandLineRunner 
	       initialData(MessageRepository repository) {
	    return (args) -> {
	        Message message1 = new Message();
            message1.setData("somkiat");
            repository.save(message1);
	    };
//        return new CommandLineRunner() {
//            
//            @Override
//            public void run(String... args) throws Exception {
//                Message message1 = new Message();
//                message1.setData("somkiat");
//                repository.save(message1);
//            }
//        };
	}
}
