package demo.example.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import demo.example.app.model.Book;

@Repository
public interface BookDao extends MongoRepository<Book, String>{

}
