package com.cg.lib.util;

import com.cg.lib.dto.UserDTO;
import com.cg.lib.entity.User;
import com.cg.lib.dto.BooksDTO;
import com.cg.lib.entity.Books;

public class Util {
	
	public static User DtoToUser(UserDTO dto) {
		User user1 = new User();
		user1.setDOB(dto.getDOB());
		user1.setEmail(dto.getEmail());
		user1.setFirstName(dto.getFirstName());
		user1.setLastName(dto.getLastName());
		user1.setMob_No(dto.getMob_No());
		user1.setPassword(dto.getPassword());
		user1.setUsername(dto.getUsername());
		user1.setApproved(dto.getApproved());
		return user1;
	}
	
	public static Books DtoToBooks(BooksDTO book) {
		Books newBook = new Books();
		newBook.setAuthorName(book.getAuthorName());
		newBook.setBookName(book.getBookName());
		newBook.setPublishedYear(book.getPublishedYear());
		return newBook;
	}

}
