package com.example.Bookstore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository bRepository;


	@Test
	public void findByYearTest() {
		List<Book> books = bRepository.findByYear(2001);
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Good To Great");
	}

	
	@Test
	public void findByAuthorTest() {
		List<Book> books = bRepository.findByAuthor("Jim Collins");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Good To Great");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Effective Java", "Joshua Bloch", 2017, "978-0134685991", 33.96);
		bRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	

}
