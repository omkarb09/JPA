package com.lti.service;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface AuthorService {
	public List<Book> findAllBooks();
	
	public List<Book> findBookByAuthor(String authorName);
	
	public List<Book> findBookWithinPrice(double min,double max);
	
	public List<Author> findAuthorForBookId(long bookISBN);
	
}
