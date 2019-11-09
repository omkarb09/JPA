package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
public class Author implements Serializable
{
	@Id
	private int authorId;
	private String authorName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="AuthorBook",joinColumns={@JoinColumn(name="authorId")},inverseJoinColumns={@JoinColumn(name="bookISBN")})
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		super();
	}

	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}
	
	public void addBooks(Book book)
	{
		books.add(book);
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "AuthorId :" + authorId + ", AuthorName :" + authorName + "";
	}
	
	
	
}
