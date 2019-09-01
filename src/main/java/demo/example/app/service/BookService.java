package demo.example.app.service;

import java.util.List;
import java.util.Optional;

import demo.example.app.model.Book;

public interface BookService {
	
	public Book save(Book b);
	
	public List<Book> list();
	
	public void deleteBookById(String id);
	
	public Optional<Book> findById(String id);
	
	public Book update(Book b);
}
