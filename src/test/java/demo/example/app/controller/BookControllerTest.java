package demo.example.app.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.example.app.model.Book;
import demo.example.app.service.BookService;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookService service;
	
	ObjectMapper om;
	
	@Before
	public void init() {
		om = new ObjectMapper();
	}
	
	@Test
	public void list_test() throws JsonProcessingException, Exception {
		
		
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Book1", "Author1", "Summary", "1982", "500", "ISBN1"));
		books.add(new Book("Book2", "Author2", "Summary book2", "1900", "456", "ISBN test"));
		
		when(service.list()).thenReturn(books);
		
		
		mockMvc.perform(get("/books/")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is("Book1")))
				.andExpect(jsonPath("$[1].name", is("Book2")))
				;
	}
	
	@Test
	public void save_test() throws JsonProcessingException, Exception {
		
		Book book = new Book("Book1", "Author1", "Summary", "1982", "100", "ISBN1");
		
		when(service.save(any(Book.class))).thenReturn(book);
		
		mockMvc.perform(post("/books/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(om.writeValueAsString(book)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("Book1")))
				.andExpect(jsonPath("$.author", is("Author1")))
				.andExpect(jsonPath("$.summary", is("Summary")))
				.andExpect(jsonPath("$.year", is("1982")))
				.andExpect(jsonPath("$.page", is("100")))
				.andExpect(jsonPath("$.isbn", is("ISBN1")))
				;
		
	}
	
}
