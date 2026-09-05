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
		if (car != null) {
			Engine engine = car.getEngine();
			System.out.println(engine);
			return car;
		} else {
			throw new CarNotFoundException("Car not found");
		}
	}

	public Engine findEngineById(int id) {

		Engine engine = em.find(Engine.class, id);

		if (engine == null) {
			throw new EngineNotFoundException("Engine Not Found Exception");
			
		} 
		
		return engine;

	}

	public void findAllCar() {
		String q1 = "select car from Car car ";

		Query query1 = em.createQuery(q1);
		List<Car> list = query1.getResultList();

		for (Car car : list) {
			Engine engine = car.getEngine();
			System.out.println(engine);
			System.out.println(car);
		}
	}

	public void updateCarPrice(int id, double price, int hp) {
		et.begin();
		try {

			Car car = em.find(Car.class, id);

			if (car != null) {

				Engine engine = car.getEngine();
				engine.setHp(hp);
				car.setPrice(price);
				et.commit();
				System.out.println("car and engine got updated..");
			} else {
				throw new CarNotFoundException("car not found");
			}

		} catch (Exception e) {
			et.rollback();
		}

	}

	public void updateEngineHp(int id, int hp) {

		et.begin();

		try {

			Engine engine = findEngineById(id);

			if (engine != null) {
				engine.setHp(hp);
				et.commit();
				System.out.println("Engine HP updated successfully.");
			} else {
				et.rollback();
				System.out.println("engine not found");
			}

		} catch (Exception e) {
			et.rollback();
		}

	}

	public void removeCar(int id) {

		et.begin();

		try {

			Car car = findCarById(id);

			if (car != null) {
				Engine engine = car.getEngine();
				em.remove(car);
				em.remove(engine);
				et.commit();
				System.out.println("car and engine get removed");
			} else {
				throw new CarNotFoundException("CAR NOT FOUND");
			}
		} catch (Exception e) {
			et.rollback();
		}
	}

	public void addCar(String type, int hp, String brand, double price) {

		Engine engine = new Engine(type, hp);
		Car car = new Car(brand, price, engine);

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
