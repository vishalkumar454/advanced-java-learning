package view;

import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Course c1 = new Course("java", 10000);
		Course c2 = new Course("python",8000);
		Course c3 = new Course("sql", 5000);
		
		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(c1);
		courses1.add(c3);
		
		List<Course> courses2 = new ArrayList<Course>();
		courses2.add(c2);
		courses2.add(c3);
		
		List<Course> courses3 = new ArrayList<Course>();
		courses3.add(c2);
		
		Student s1 = new Student("nitin", 21);
		Student s2 = new Student("jitin", 22);
		Student s3 = new Student("kitin", 23);
		
		List<Student> student1 = new ArrayList<Student>();
		student1.add(s2);
		
		List<Student> student2 = new ArrayList<Student>();
		student2.add(s1);
		student2.add(s3);
		
		List<Student> student3 = new ArrayList<Student>();
		student3.add(s1);
		student3.add(s2);
		
		s1.setCourses(courses1);
		s2.setCourses(courses2);
		s3.setCourses(courses3);
		
		c1.setStudents(student1);
		c2.setStudents(student2);
		c3.setStudents(student3);
		
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		et.commit();
		
	}
}
