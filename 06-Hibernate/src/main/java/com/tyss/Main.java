package com.tyss;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Product product = new Product("shop",100);
		
//		Student student = new Student(102,"vivek",22);
		
//		Marker marker = new Marker("Red", 10.0);
		
		Marker marker = em.find(Marker.class, 1);
		
		et.begin();
		
//		em.persist(marker);
		marker.setColour("Blue");
		et.commit();
	}
	
}
