package view;

import java.util.ArrayList;
import java.util.List;

import entity.Course;
import entity.Student;
import repository.StudentRepository;

public class Main {
	
	public static void main(String[] args) {
		
		StudentRepository studentRepository = new StudentRepository();
		
		System.out.println("Enter the option.. ");
		System.out.println("1. Save data ");
		System.out.println("2. find student based on id");
		System.out.println("3. adding new course to existing student");
		int option = 3;
		
		switch (option) {
		case 1:
			
			Course c1 = new Course("java", 10000);
			Course c2 = new Course("python",8000);
			Course c3 = new Course("sql", 5000);
			
			List<Course> courses1 = new ArrayList<Course>();
			courses1.add(c1);
			courses1.add(c3);
			
			List<Course> courses2 = new ArrayList<Course>();
			courses2.add(c2);
			
			List<Course> courses3 = new ArrayList<Course>();
			courses3.add(c2);
			
			List<Course> courses = new ArrayList<Course>();
			courses.add(c1);
			courses.add(c2);
			courses.add(c3);
			
			Student s1 = new Student("nitin", 21, courses1);
			Student s2 = new Student("jitin", 22, courses2);
			Student s3 = new Student("kitin", 23, courses3);
			
			List<Student> students = new ArrayList<Student>();
			students.add(s1);
			students.add(s2);
			students.add(s3);
			
			studentRepository.saveStudent(students, courses);
			
			break;
			
		case 2:
			int id = 52;
			studentRepository.findStudent(id);
			break;
			
		case 3:
			id = 52;
			
			Course c4 = new Course("manual testing", 4000);
			List<Course> c = new ArrayList<Course>();
			c.add(c4);
			studentRepository.inclueNewCourse(id,c);
			
			break;

		default:
			break;
		}
		
		
	}
}
