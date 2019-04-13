package com.cg.jpastart.dao;

import javax.persistence.EntityManager;

import com.cg.jpastart.entities.Author;
import com.cg.jpastart.util.JPAUtil;

public class CRUDDAOImpl implements CRUDDAO{

	public void add(Author author) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
	}
	
	public void update(Author author) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Author authorPrev = em.find(Author.class, author.getAuthorId());
		authorPrev.setFirstName(author.getFirstName());
		authorPrev.setMiddleName(author.getMiddleName());
		authorPrev.setLastName(author.getLastName());
		authorPrev.setPhoneNo(author.getPhoneNo());
		em.persist(authorPrev);
		em.getTransaction().commit();
	}
	
	public void delete(int id) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Author author = em.find(Author.class, id);
		em.remove(author);
		em.getTransaction().commit();
	}
}
