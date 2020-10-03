package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;
import com.example.Bookstore.repository.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	/* First running: delete spring.jpa.hibernate.ddl-auto=none in application.properties) 
	 * 				  use CommandLineRunner method
	 * => Create new tables with test data 
	 * 
	 * After first running: insert spring.jpa.hibernate.ddl-auto=none to application properties. 
	 * 						block CommandLineRunner method
	 * => Using existing tables with stored data
	 */
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository, UserRepository urepository) {
		return (args) -> {
			log.info("save categories");
			Category c1 = new Category("Business");
			Category c2 = new Category("Novel");
			Category c3 = new  Category("Technology");
			cRepository.save(c1);
			cRepository.save(c2);
			cRepository.save(c3);
			
			log.info("save few books");
			repository.save(new Book("Thinking, Fast and Slow", "Daniel Kahneman", 2012, "0141033576", 11.39, c1));
			repository.save(new Book("Good To Great", "Jim Collins", 2001, "0712676090", 18.60, c1));
			
			// Create users: user/user, admin/admin
			User user1 = new User("user", "$2a$10$zTvn5SMAQ.NSO/jnY3PjAueq2qEKG1gVLXASHCob6q6.EpBDj90H6", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$Qflab20ugY5RFyC65P.2VuqGPGLvlJEuzGOqZsB21j9j8tJlbcrGe", "admin@email.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
