package com.example;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.model.Book;
import com.example.model.Person;
import com.example.service.PersonService;

@SpringBootApplication
@EnableJpaRepositories
public class H2DemoApplication implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger("H2DemoApplication");
	
	@Autowired
	private PersonService service;
	
	public static void main(String[] args) {
		SpringApplication.run(H2DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
		p.setFirstName("First1");
		p.setLastName("Last1");
		
		Book b1 = new Book();
		b1.setTitle("Book1");
		b1.setAuthor(p);
		
		Book b2 = new Book();
		b2.setTitle("Book2");
		b2.setAuthor(p);
		
		List<Book> books = Arrays.asList(b1,b2);
		
		p.setBooks(books);
		service.save(p);
		
		LOG.info("*************Person Saved Successfully*************");
		
		service.delete(p);
		LOG.info("*************Person Deleted Successfully*************");
		
	}
}
