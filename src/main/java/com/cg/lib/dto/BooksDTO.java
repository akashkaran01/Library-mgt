package com.cg.lib.dto;

import java.time.LocalDate;

public class BooksDTO {
	
	private String bookName;
	private String authorName;
	private LocalDate publishedYear;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public LocalDate getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(LocalDate publishedYear) {
		this.publishedYear = publishedYear;
	}	
	
	

}
