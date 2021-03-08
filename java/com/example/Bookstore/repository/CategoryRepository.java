package com.example.Bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Bookstore.domain.Category;
@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findByName (String name);

}
