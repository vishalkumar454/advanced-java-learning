package view;

import java.util.Scanner;

import entity.Bank;
import exception.BankNotFoundException;
import repository.OneToManyRepository;

public class Main {
	
	public static void main(String[] args) throws BankNotFoundException, Exception {
		
		OneToManyRepository oneToManyRepository = new OneToManyRepository();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Read all bank and account details");
		System.out.println("2. Find bank based on id ");
		System.out.println("3. update bank based on Id");
		System.out.println("4. remove bank based on Id");
		System.out.println("5. Add bank account");
		
		System.out.print("Enter options : ");
		int option = sc.nextInt();
		
		switch (option) {
		case 1:
			oneToManyRepository.findAllBankAccount();
			break;
			
		case 2:
			System.out.print("Enter id of bank : ");
			int id = sc.nextInt();
			Bank bank = oneToManyRepository.findBankById(id);
			System.out.println(bank);
			break;
			
		case 3:
			System.out.print("Enter id of bank : ");
			id = sc.nextInt();
			System.out.print("Enter ifsc of bank : ");
			String ifsc = sc.next();
			System.out.print("Enter ac_no of account : ");
			long ac_no = sc.nextLong();
			
			oneToManyRepository.updateBankAccount(id,ifsc,ac_no);
			
			break;
			
		case 4:
			System.out.print("Enter id of bank : ");
			id = sc.nextInt();
			oneToManyRepository.removeBankAccount(id);
			break;
			
		case 5:
			oneToManyRepository.createBankAccount();
						
			break;

		default:
			break;
		}
		
	}
}
