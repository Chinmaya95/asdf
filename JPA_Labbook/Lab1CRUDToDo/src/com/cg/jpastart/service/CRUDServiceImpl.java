package com.cg.jpastart.service;

import com.cg.jpastart.dao.CRUDDAO;
import com.cg.jpastart.dao.CRUDDAOImpl;
import com.cg.jpastart.entities.Author;

public class CRUDServiceImpl implements CRUDService {
	
	private CRUDDAO dao = new CRUDDAOImpl();

	@Override
	public void add(Author author) {
		// TODO Auto-generated method stub
		dao.add(author);
	}

	@Override
	public void update(Author author) {
		// TODO Auto-generated method stub
		dao.update(author);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
