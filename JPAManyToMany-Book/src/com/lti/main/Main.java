package com.lti.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.service.AuthorServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		//Define Books
		Book book1 = new Book();
		book1.setBookISBN(1111);
		book1.setBookTitle("Harry Potter");
		book1.setPrice(450);
		
		Book book2 = new Book();
		book2.setBookISBN(2222);
		book2.setBookTitle("Inferno");
		book2.setPrice(550);
		
		Book book3 = new Book();
		book3.setBookISBN(3333);
		book3.setBookTitle("Sea of Poppies");
		book3.setPrice(650);
		
		//Define Author
		
		Author author1 = new Author();
		author1.setAuthorId(1);
		author1.setAuthorName("JKRowling");
		
		author1.addBooks(book1);
		
		Author author2 = new Author();
		author2.setAuthorId(2);
		author2.setAuthorName("Dan Brown");
		
		author2.addBooks(book2);
		author2.addBooks(book3);
		
		//save author using entity manager
			/*entityManager.getTransaction().begin();
			entityManager.persist(author1);
			entityManager.persist(author2);
			entityManager.getTransaction().commit();*/
		
		AuthorServiceImpl service = new AuthorServiceImpl();
		//Read all books functionality
		/*
		List<Book> list = service.findAllBooks();
		
		for(Book u : list)
		{
			System.out.println(u);
		}*/
		
		//Read between min and max
		/*List<Book> list = service.findBookWithinPrice(400, 600);
		
		for(Book u : list)
		{
			System.out.println(u);
		}*/
		
		//Read book by Author
		/*List<Book> list = service.findBookByAuthor("Dan Brown");
		
		for(Book u : list)
		{
			System.out.println(u);
		}*/
		
		//Read author for book id
		/*List<Author> list = service.findAuthorForBookId(2222);
		
		for(Author u : list)
		{
			System.out.println(u);
		}*/
		
	}

}
