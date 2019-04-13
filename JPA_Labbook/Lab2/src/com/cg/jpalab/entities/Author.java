package com.cg.jpalab.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author_master")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

		//required for Date and Calendar Types
	@Column(name = "name")
	private String authorName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_authors", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = { @JoinColumn(name = "book_isbn") })
	private Set<Book> books = new HashSet<>();	//required to avoid NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.getBooks().add(book);
	}
	
}
