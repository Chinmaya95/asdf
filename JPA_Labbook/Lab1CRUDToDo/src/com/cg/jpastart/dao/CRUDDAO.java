package com.cg.jpastart.dao;

import com.cg.jpastart.entities.Author;

public interface CRUDDAO {
	
	public void add(Author author);
	public void update(Author author);
	public void delete(int id);

}
