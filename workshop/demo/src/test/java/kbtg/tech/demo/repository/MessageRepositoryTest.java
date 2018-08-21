package kbtg.tech.demo.repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MessageRepositoryTest {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Before
    public void initial() {
        messageRepository.deleteAll();
    }

    @Test
    public void save_and_findbyid_of_new_message() {
       // Save
       Message newMessage = new Message();
       newMessage.setData("somkiat");
       messageRepository.save(newMessage);
       
       // Find by id
       Optional<Message> result 
           = messageRepository.findById(newMessage.getId());
       
       assertTrue(result.isPresent());
       assertEquals("somkiat", result.get().getData());
    }
    
    @Test
    public void save_and_count_of_a_message() {
       // Save
       Message newMessage = new Message();
       newMessage.setData("somkiat");
       messageRepository.save(newMessage);
       // Count
       assertEquals(1, messageRepository.count());
    }

}
