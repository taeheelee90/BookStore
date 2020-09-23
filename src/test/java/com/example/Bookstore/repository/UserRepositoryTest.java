package com.example.Bookstore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void findByUsernameTest() {
		User user = repository.findByUsername("user");
		assertThat(user.getRole()).isEqualTo("USER");

	}
	
	@Test
	public void createUserTest() {
		User user = new User("user2", "$2a$10$zTvn5SMAQ.NSO/jnY3PjAueq2qEKG1gVLXASHCob6q6.EpBDj90H6", "user2@email.com", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}

}
