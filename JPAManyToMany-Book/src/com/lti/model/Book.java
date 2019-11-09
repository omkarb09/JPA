package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book implements Serializable
{
	@Id
	private long bookISBN;
	private String bookTitle;
	private double price;
	
	@ManyToMany(mappedBy="books")
	private Set<Author> authors = new HashSet<>();

	public Book() {
		super();
	}

	public Book(long bookISBN, String bookTitle, double price) {
		super();
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
		this.price = price;
	}

	public long getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(long bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "BookISBN :" + bookISBN + "\nBookTitle : " + bookTitle + "\nPrice : " + price + "\nAuthors:" + authors
				+ "\n";
	}
	
	
	
}
