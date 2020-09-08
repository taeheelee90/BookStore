package com.example.Bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findByName (String name);

}
