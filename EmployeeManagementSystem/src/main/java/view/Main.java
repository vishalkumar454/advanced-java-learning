package view;

import java.util.Scanner;

import entity.Employee;
import repository.EmployeeRepository;

public class Main {

	static EmployeeRepository employeeRepository = new EmployeeRepository();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Employee");
		System.out.println("2. find the Employee based on Id");
		System.out.println("3. update the Employee based on Id");
		System.out.println("4. delete the Employee based on Id");
		System.out.println("5. Find all the employee");
		System.out.print("Enter the Option : ");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.print("ID : ");
			int id = sc.nextInt();

			System.out.print("Name : ");
			String name = sc.next();

			System.out.print("salary : ");
			double salary = sc.nextDouble();

			System.out.print("Dept : ");
			String dept = sc.next();

			Employee employee = new Employee(id, name, salary, dept);
			employeeRepository.addEmployee(employee);

			break;

		case 2:
			System.out.print("ID : ");
			id = sc.nextInt();
			System.out.println(employeeRepository.findEmployee(id));
			break;

		case 3:
			System.out.print("ID : ");
			id = sc.nextInt();
			System.out.println("What you want to modify : ");
			
			
			System.out.println("1. name the Employee");
			System.out.println("2. salary the Employee ");
			System.out.println("3. department the Employee ");
			System.out.println("4. update the Employee salary with hike 10%");

			System.out.print("Enter the Option : ");
			int updateOption = sc.nextInt();

			switch (updateOption) {
			
			case 1:
				System.out.print("Enter new name : ");
				String newName = sc.next();
				employeeRepository.updateEmployeeName(id,newName);
				
				break;
			
			case 2:
				System.out.print("Enter new salary : ");
				double newSalary = sc.nextDouble();
				employeeRepository.updateEmployeeSalary(id, newSalary);
				
				break;
				
			case 3:
				System.out.print("Enter new department : ");
				String newDepartment = sc.next();
				employeeRepository.updateEmployeeDept(id, newDepartment);
				
				break;
				
			case 4:
				System.out.print("ID : ");
				id = sc.nextInt();
				employeeRepository.updateEmployeeSalaryWithHike10(id);
				
				break;
				
			default:
				break;
			}
			
		case 4:
			System.out.print("ID : ");
			id = sc.nextInt();
			employeeRepository.removeEmployeeById(id);
			break;
			
		case 5:
			System.out.println(employeeRepository.findAllEmployee());
			break;

		default:
			break;
		}

	}
}
