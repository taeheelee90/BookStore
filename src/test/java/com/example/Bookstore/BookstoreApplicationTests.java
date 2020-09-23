package com.example.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.UserController;

//smoke testing for all controller

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bController;
	@Autowired
	private UserController uController;

	@Test
	void bookcontextLoads() throws Exception {
		assertThat(bController).isNotNull();
	}

	
	@Test
	void usercontextLoads() throws Exception {
		assertThat(uController).isNotNull();
	}
}
