package com.cg.jpalab.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpalab.entities.Author;
import com.cg.jpalab.entities.Book;

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few Books before we place Author

		Book firstBook = new Book();
		firstBook.setIsbn(1);
		firstBook.setTitle("Harry Potter 1");
		firstBook.setPrice(45);

		Book secondBook = new Book();
		secondBook.setIsbn(2);
		secondBook.setTitle("Harry Potter 2");
		secondBook.setPrice(80);

		Book thirdBook = new Book();
		thirdBook.setIsbn(3);
		thirdBook.setTitle("Sherlock Holmes 1");
		thirdBook.setPrice(15);

		Book fourthBook = new Book();
		fourthBook.setIsbn(4);
		fourthBook.setTitle("Sherlock Holmes 2");
		fourthBook.setPrice(250);

		// now define first Author and add few Books in it
		Author firstAuthor = new Author();
		firstAuthor.setId(1000);
		firstAuthor.setAuthorName("J K Rowling");

		firstAuthor.addBook(firstBook);
		firstAuthor.addBook(secondBook);

		// now define second Author and add few Books in it
		Author secondAuthor = new Author();
		secondAuthor.setId(1001);
		secondAuthor.setAuthorName("Auther Conan Doyle");

		secondAuthor.addBook(thirdBook);		
		secondAuthor.addBook(fourthBook);

		// save Authors using entity manager

		em.persist(firstAuthor);
		em.persist(secondAuthor);
		
		System.out.println("Added Authors along with Author details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
