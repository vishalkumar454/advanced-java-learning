package repository;

import entity.Car;
import entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneRepository {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = new Car();
		car.setBrand("BMW");
		car.setPrice(10000);
		
		Engine engine = new Engine();
		engine.setType("petrol");
		engine.setHp(1200);
		
		car.setEngine(engine);
		engine.setCar(car);
		
		et.begin();
		em.persist(engine);
		em.persist(car);
		et.commit();
	}
}
