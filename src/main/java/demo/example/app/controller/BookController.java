package demo.example.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.example.app.model.Book;
import demo.example.app.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping(value="/books")
	public Book addUser(@RequestBody Book b) {
		Book d = b;
		return bookService.save(d);
	}
	
	@GetMapping(value="/books")
	public List<Book> listUsers() {
		return bookService.list();
	}
	
	@DeleteMapping(value="/books/{id}")
	public ResponseEntity<Book>  remove(@PathVariable("id") String id) {
		bookService.deleteBookById(id);
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/books/{id}")
	public Book update(@PathVariable("id") String id, @RequestBody Book b) {
		return bookService.update(b);
	}
	
	@GetMapping(value="/books/{id}")
	public Optional<Book>  findById(@PathVariable("id") String id) {
		return bookService.findById(id);
	}
	
	
}
