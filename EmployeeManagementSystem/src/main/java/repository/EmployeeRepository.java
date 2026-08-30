package repository;

import java.util.List;

import entity.Employee;
import exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();

	public void addEmployee(Employee employee) {
		try {
			et.begin();
			em.persist(employee);
			et.commit();
			System.out.println("Employee data saved");
		} catch (Exception e) {
			et.rollback();
		}
	}

	public Employee findEmployee(int id) {
		Employee employee = em.find(Employee.class, id);

		if (employee != null) {
			return employee;
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}

	}
	
	public Employee updateEmployeeSalaryWithHike10(int id) {
		
		Employee employee = findEmployee(id);
		double existingSalary = employee.getSalary();
		double updatedSalary = existingSalary + (10.0/100 * existingSalary);
		employee.setSalary(updatedSalary);
		
		try {
			et.begin();
			em.merge(employee);
			et.commit();
		} catch (Exception e) {
			et.rollback();
		}
		return employee;
	}

	public void updateEmployeeName(int id, String newName) {

		try {

			Employee employee = em.find(Employee.class, id);

			if (employee != null) {
				et.begin();
				employee.setName(newName);
				et.commit();
				System.out.println("Name updated successfully");
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}

			e.printStackTrace();
		}

	}

	public void updateEmployeeSalary(int id, double salary) {

		try {

			Employee employee = em.find(Employee.class, id);

			if (employee != null) {
				et.begin();
				employee.setSalary(salary);
				et.commit();
				System.out.println("salary updated successfully");
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}

			e.printStackTrace();
		}

	}
	
	public void updateEmployeeDept(int id, String dept) {

		try {

			Employee employee = em.find(Employee.class, id);

			if (employee != null) {
				et.begin();
				employee.setDept(dept);
				et.commit();
				System.out.println("department updated successfully");
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}

			e.printStackTrace();
		}

	}
	
	public void removeEmployeeById(int id) {
		try {

			Employee employee = em.find(Employee.class, id);

			if (employee != null) {
				et.begin();
				em.remove(employee.getId());
				et.commit();
				System.out.println("employee removed successfully");
			} else {
				throw new EmployeeNotFoundException("Employee not found");
			}
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}

			e.printStackTrace();
		}
	}
	
	public List<Employee> findAllEmployee() {
		String jpql = "select e from Employee e";
		Query query = em.createQuery(jpql);
		
		return query.getResultList();
	}
}
