package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToManyRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void findBankAccount() {
		
		String q1 = "select bank from Bank bank ";
		String q2 = "select account from Account account";
		
		Query query1 = em.createQuery(q1);
		Query query2 = em.createQuery(q2);
		System.out.println(query1.getSingleResult());
		System.out.println(query2.getResultList());
	}
	
	
}	
