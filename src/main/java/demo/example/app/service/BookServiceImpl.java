package demo.example.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.app.dao.BookDao;
import demo.example.app.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;
	
	@Override
	public Book save(Book b) {
		return dao.save(b);
	}

	@Override
	public List<Book> list() {
		return dao.findAll();
	}

	@Override
	public void deleteBookById(String id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Book> findById(String id) {
		return dao.findById(id);
	}
	
	public Book update(Book b) {
		return dao.save(b);
	}

}
