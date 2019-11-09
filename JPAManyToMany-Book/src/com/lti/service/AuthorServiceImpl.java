package com.lti.service;

import java.util.List;

import com.lti.dao.AuthorDaoImpl;
import com.lti.model.Author;
import com.lti.model.Book;

public class AuthorServiceImpl implements AuthorService
{
	private AuthorDaoImpl authorDao;
	public AuthorServiceImpl() {
		authorDao = new AuthorDaoImpl();
	}
	@Override
	public List<Book> findAllBooks()
	{
		List<Book>list= authorDao.readAllBooks();
		return list;
	}

	@Override
	public List<Book> findBookByAuthor(String authorName) {
		
		return authorDao.readBookByAuthor(authorName);
	}

	@Override
	public List<Book> findBookWithinPrice(double min, double max) {
	
		List<Book>list= authorDao.readBookWithinPrice(min, max);
		return list;
	}

	@Override
	public List<Author> findAuthorForBookId(long bookISBN) {
		return authorDao.readAuthorForBookId(bookISBN);
	}
	
}
