package repository;

import java.util.List;

import entity.Car;
import entity.Engine;
import exception.CarNotFoundException;
import exception.EngineNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OneToOneRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Car findCarById(int id) {
		Car car = em.find(Car.class, id);
		if(car != null) {
			Engine engine = car.getEngine();
			System.out.println(engine);
			return car;
		}else {
			throw new CarNotFoundException("Car not found");
		}
	}
	
	public Engine findEngineById(int id) {
		Engine engine = em.find(Engine.class, id);
		
		if(engine != null) {
			return engine;
		}else {
			throw new EngineNotFoundException("Engine Not Found Exception");
		}
	}
	
	public List<Car> findAllCar() {
		String q1 = "select car from Car car ";
		String q2 = "select engine from Engine engine";
		
		Query query1 = em.createQuery(q1);
		Query query2 = em.createQuery(q2);
		System.out.println(query2.getResultList());
		return query1.getResultList();
	}
//	
//	public List<Engine> findAllEngine() {
//		String q = "select engine from Engine engine";
//		Query query = em.createQuery(q);
//		return query.getResultList();
//	}
	
	public void updateCarPrice(int id, double price,int hp) {
		Car car = findCarById(id);
		Engine engine = car.getEngine().setHp(hp);
		car.setPrice(price);
		try {
			et.begin();
			em.merge(engine);
			em.merge(car);
			et.commit();
			System.out.println("car price updated");
			
		} catch (Exception e) {
			et.rollback();
		}
	}
	
	public void updateEngineHp(int id, int hp) {
		Engine engine = findEngineById(id);
		engine.setHp(hp);
		
		try {
			et.begin();
			em.merge(engine);
			et.commit();
			System.out.println("HP of engine updated");
		} catch (Exception e) {
			et.rollback();
		}
		
	}
	
	public void removeCar(int id) {
		Car car = findCarById(id);
		Engine engine = car.getEngine();
		
		try {
			et.begin();
			em.remove(car);
			em.remove(engine);
			et.commit();
			System.out.println("car removed");
		} catch (Exception e) {
			et.rollback();
		}
	}
	
	public void addCar(String type, int hp, String brand, double price) {
		
		Engine engine = new Engine(type,hp);
		Car car = new Car(brand, price, engine );
		
		try {
			et.begin();
			em.persist(engine);
			em.persist(car);
			et.commit();
			System.out.println("Engine object created .. ");
			System.out.println("Car object created .. ");
		} catch (Exception e) {
			et.rollback();
		}
	}

}
