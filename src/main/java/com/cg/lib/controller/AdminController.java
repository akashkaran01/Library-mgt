package com.cg.lib.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lib.dto.BooksDTO;
import com.cg.lib.entity.Books;
import com.cg.lib.service.AdminServiceImpl;
import com.cg.lib.util.Util;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	  private static final Logger Log= LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminServiceImpl service;
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<String> adminLogin(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		String result = service.adminLogin(username, password);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		Log.info("Admin Login Successful...");
		return response;
	}

	@GetMapping("/viewAllBooks") 
	public ResponseEntity<List<Books>> viewAllBooks(){
		List<Books> allBooks = service.viewAllBooks();
		ResponseEntity<List<Books>> response = new ResponseEntity<>(allBooks, HttpStatus.OK);
		Log.info("All Books Displayed...");
		return response;
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@RequestBody BooksDTO newBook)
	{
		Books book = Util.DtoToBooks(newBook);
		String result = service.addBook(book);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		Log.info("Book added successfully...");
		return response;
	}
	
	@PutMapping("/editBook")
	public ResponseEntity<String> editBook(@RequestBody BooksDTO newBook)
	{
		Books book = Util.DtoToBooks(newBook);
		String result = service.editBook(book);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		Log.info("Book edited successfully...");
		return response;
	}
	
	@DeleteMapping("/deleteBook/{bookName}")
	public ResponseEntity<String> deleteBook(@PathVariable String bookName)
	{
		String result = service.deleteBook(bookName);
		ResponseEntity<String> response = new ResponseEntity<String>(result, HttpStatus.OK);
		Log.info("Book deleted successfully...");
		return response;
	}
	
	
}
