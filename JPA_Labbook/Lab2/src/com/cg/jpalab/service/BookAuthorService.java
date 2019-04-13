package com.cg.jpalab.service;

import java.util.List;

import com.cg.jpalab.entities.Author;
import com.cg.jpalab.entities.Book;

public interface BookAuthorService {
	
	public List<Book> getAllBooks();
	public List<Book> getAllBooksByAuthor(Author author);
	public List<Book> getAllBooksByPriceRange(double lower,double upper);
	public String getAuthorNameByBookId(int bookId);
}
