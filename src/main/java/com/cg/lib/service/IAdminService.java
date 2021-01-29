package com.cg.lib.service;

import java.util.List;

import com.cg.lib.entity.Books;

public interface IAdminService {
	
	String adminLogin(String username, String password);
	
	List<Books> viewAllBooks();
	
	String addBook(Books newBook);
	
	String editBook(Books newBook);
	
	String deleteBook(String bookName);

}
