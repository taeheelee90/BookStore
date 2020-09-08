package com.example.Bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.Book;

public interface BookRepository extends CrudRepository <Book, Long> {

}
