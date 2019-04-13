package com.cg.jpastart.service;

import com.cg.jpastart.entities.Author;

public interface CRUDService {

	public void add(Author author);
	public void update(Author author);
	public void delete(int id);
}
