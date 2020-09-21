package com.example.Bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
