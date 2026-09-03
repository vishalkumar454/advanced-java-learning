package repository;

import java.util.List;

import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentRepository {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vishal");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(List<Student> students, List<Course> courses) {

		et.begin();
		for (Course course : courses) {
			em.persist(course);
		}
		for (Student student : students) {
			em.persist(student);
		}
		et.commit();
	}
	
	public Student findStudent(int id) {
		Student student = em.find(Student.class, id);
		List<Course> courses = student.getCourses();
		
		System.out.println("Student details ..");
		System.out.println(student);
		
		System.out.println("Courses details...");
		for (Course course : courses) {
			System.out.println(course);
		}
		
		return student;
	}
	
	public void inclueNewCourse(int id , List<Course> courses) {
		Student student = em.find(Student.class, id);
		em.persist(student);
		for (Course course : courses) {
			
			student.setCourses(courses);
			em.persist(course);
		}
		System.out.println("courses inserted");
	}
	
	public void removeStudent(int id) {
		Student student = findStudent(id);
		List<Course> courses = student.getCourses();
		
		et.begin();
		em.remove(courses);
		em.remove(student);
		et.commit();
	}
	
	public void removeCourseByid(int studId, int corsId) {
		
	}
}
