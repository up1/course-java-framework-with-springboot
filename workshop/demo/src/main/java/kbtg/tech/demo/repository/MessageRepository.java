package kbtg.tech.demo.repository;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository 
     extends CrudRepository<Message, Integer> {

}
