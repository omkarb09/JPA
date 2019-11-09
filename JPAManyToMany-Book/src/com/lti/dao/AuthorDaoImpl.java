package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.utils.JpaUtils;

public class AuthorDaoImpl implements AuthorDao
{
private EntityManager entityManager;
	
	public AuthorDaoImpl() 
	{
		entityManager = JpaUtils.getEntityManager();
	}
	@Override
	public List<Book> readAllBooks() {
		TypedQuery<Book> tquery = entityManager.createQuery("SELECT b FROM Book b",Book.class);
		List<Book> list = tquery.getResultList();
		return list;
	}

	@Override
	public List<Book> readBookByAuthor(String authorName) {
		TypedQuery<Book> tquery = entityManager.createQuery("SELECT b FROM Book b INNER JOIN b.authors a where a.authorName=:name",Book.class);
		tquery.setParameter("name", authorName);
		List<Book> list = tquery.getResultList();
		return list;
	}

	@Override
	public List<Book> readBookWithinPrice(double min, double max) {
		TypedQuery<Book> tquery = entityManager.createQuery("SELECT b FROM Book b WHERE b.price BETWEEN "+min+" AND "+max+" ",Book.class);
		List<Book> list = tquery.getResultList();
		return list;
	}

	@Override
	public List<Author> readAuthorForBookId(long bookISBN) {
		
		//TypedQuery<Author> tquery = entityManager.createQuery("SELECT a FROM Author a WHERE a.authorId IN (SELECT authorId FROM AuthorBook b WHERE b.bookISBN="+bookISBN+")",Author.class);
		TypedQuery<Author> tquery = entityManager.createQuery("SELECT a FROM Author a INNER JOIN a.books b WHERE b.bookISBN=:bookid",Author.class);
		tquery.setParameter("bookid", bookISBN);
		List<Author> list = tquery.getResultList();
		return list;
	}

}
