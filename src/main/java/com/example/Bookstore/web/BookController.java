package com.example.Bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.Bookstore.model.Book;


@Controller
public class BookController {

	
	 @GetMapping("/index")
	 public String bookForm (Model model) { 
		 model.addAttribute("book", new Book());
		 return "bookForm";
	}
	
	 @PostMapping ("/index")
	 public String bookSubmit(@ModelAttribute Book book, Model model) {
		 model.addAttribute("book", book);
		 return "result";
	 }
	 
	
	 

}
