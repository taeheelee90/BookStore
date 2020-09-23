package com.example.Bookstore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameTest() {
		List<Category> categories = repository.findByName("Technology");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getId()).isEqualTo(3);
	}

	
	@Test
	public void createCategoryTest() {
		Category category = new Category("Art");
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}
}
