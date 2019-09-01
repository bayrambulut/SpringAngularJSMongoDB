package demo.example.app.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import demo.example.app.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookDaoTest {

	static Logger logger = Logger. getLogger(BookDaoTest.class.getName());

	
	@Autowired
	BookDao dao;
	
	@Test
	@Rollback(true)
	public void test_dao() throws Exception {
		
		Book book = new Book("Book1", "Author1", "Summary", "1982", "500", "ISBN1");
		Book newBook = dao.save(book);
		
		Book getBook = dao.findById(newBook.getId())
				.orElseThrow(() -> new Exception("not found"));
		
		logger.info("id ..... : " + newBook.getId());
		
		assertEquals(newBook.getId(), getBook.getId());
	}
	
	@Before
	public void init() {
		
	}
	
	
}
