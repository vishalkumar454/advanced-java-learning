package view;

import java.util.Scanner;

import repository.OneToManyRepository;

public class Main {
	
	public static void main(String[] args) {
		
		OneToManyRepository oneToManyRepository = new OneToManyRepository();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Read bank account data");
		System.out.println("3. update bank based on Id");
		System.out.println("4. update account based on Id");
		System.out.println("5. delete bank based on Id");
		System.out.println("5. delete account based on Id");
		
		int option = sc.nextInt();
		
		switch (option) {
		case 1:
			oneToManyRepository.findBankAccount();
			break;

		default:
			break;
		}
		
	}
}
