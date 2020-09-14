package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	// home page
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	// list page
	@RequestMapping(value = "/list")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";

	}
	
	// Restful service to get all books
	@RequestMapping(value = "/books",method = RequestMethod.GET )
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) bookRepository.findAll();
	}
	
	// Restful service to get book by id
	@RequestMapping(value ="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return bookRepository.findById(bookId);
	}
	
	
	
	// add new book
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "bookform";
	}

	// submitPage
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveBook(Book book, Model model) {
		model.addAttribute("book", bookRepository.save(book));
		// return "saveBook";
		return "redirect:list";
	}

	// edit book
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}

	// delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../list";
	}

}
