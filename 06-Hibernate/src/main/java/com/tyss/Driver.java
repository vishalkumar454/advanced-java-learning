package com.tyss;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = new Student(101,"vishal",21);
		
		try {
			et.begin();
			em.persist(s);
			et.commit();
			System.out.println("saved");
			
		}catch(Exception e) {
			et.rollback();
		}
	}

}
