package com.example.Bookstore.web;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Bookstore.model.Book;

@Controller
public class BookController {

	/*
	 * @GetMapping("/books") public String bookController(Model model) { List<Book>
	 * books = new ArrayList<Book>(); Book book1 = new Book("Java Cookbook",
	 * "Darwin, Ian F.", 2001, "0-596-00170-3", 59.00 ); books.add(book1);
	 * model.addAttribute("book", books); return "book"; }
	 */

	@GetMapping("/")
	public String bookController(Book book) {
		return "Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nYear: " + book.getYear() + "\nISBN: "
				+ book.getIsbn() + "\nPrice: " + book.getPrice();
	}

}
