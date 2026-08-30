package queryParameter;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		// positional parameter
		
//		String jpql = "select e from Employee e where e.id=?1 and e.name=?2";
//		
//		Query query = em.createQuery(jpql);
//		query.setParameter(1, 101);
//		query.setParameter(2, "Vishal");
		
		// named parameter
		
		String jpql = "select e from Employee e where e.id = :empId and e.name = :empName";
		Query query = em.createQuery(jpql);
		query.setParameter("empId", 101);
		query.setParameter("empName", "Vishal");
		
		Employee emp = (Employee) query.getSingleResult();
		System.out.println(emp);
	}
}
