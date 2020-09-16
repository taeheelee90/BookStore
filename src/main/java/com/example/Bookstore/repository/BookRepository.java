package com.example.Bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Bookstore.domain.Book;

@RepositoryRestResource
public interface BookRepository extends CrudRepository <Book, Long> {
		
	// fetch by year
	List<Book> findByYear(@Param("year") int year);
	
	// fetch by author
	List<Book> findByAuthor(@Param("author") String author);
	
	
	
}
