package com.lti.dao;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface AuthorDao {
	public List<Book> readAllBooks();
	
	public List<Book> readBookByAuthor(String authorName);
	
	public List<Book> readBookWithinPrice(double min,double max);
	
	public List<Author> readAuthorForBookId(long bookISBN);
}
