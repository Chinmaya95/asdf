package com.cg.jpastart.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null)
			entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		return entityManagerFactory;
	}
	
	
	
}
