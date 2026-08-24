package view;

import java.util.Scanner;

import entity.Employee;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add employee");
		
		System.out.print("Enter the Option : ");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			System.out.print("ID : ");
			int id = sc.nextInt();
			
			System.out.print("Name : ");
			String name = sc.next();
			
			System.out.print("salary : ");
			double salary = sc.nextDouble();
			
			System.out.print("Dept : ");
			String dept = sc.next();
			
			Employee employee = new Employee(id, name, id, dept);
			break;
			
		default:
			break;
		}
		
		
	}
}
