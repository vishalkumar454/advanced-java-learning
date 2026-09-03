package view;

import java.util.Scanner;

import entity.Car;
import entity.Engine;
import repository.OneToOneRepository;

public class Main {

	static OneToOneRepository oneToOneRepository = new OneToOneRepository();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER OPTION WHAT OPERATION YOU WANT TO DO");
		System.out.println("1. find car based on id");
		System.out.println("3. find All car");
		System.out.println("5. Update the price of a car");
		System.out.println("6. Update the hp of a engine");
		System.out.println("7. remove the car based on id");
		System.out.println("8. Add Car");

		System.out.print("Enter option : ");
		int option = sc.nextInt();

		switch (option) {

		case 1:
			System.out.print("Enter id : ");
			int id = sc.nextInt();
			System.out.println(oneToOneRepository.findCarById(id));
			break;

		case 3:
			System.out.println(oneToOneRepository.findAllCar());
			break;

		case 5:
			System.out.print("Enter id : ");
			id = sc.nextInt();
			System.out.println();
			
			System.out.print("Enter hp if you want to update hp : ");
			int hp = sc.nextInt();
			
			System.out.println();
			
			System.out.print("Enter updated price : ");
			double price = sc.nextDouble();

			oneToOneRepository.updateCarPrice(id, price, hp);

			break;

//		case 6:
//			System.out.print("Enter id : ");
//			id = sc.nextInt();
//			System.out.println();
//			System.out.print("Enter updated hp : ");
//			int hp = sc.nextInt();
//
//			oneToOneRepository.updateEngineHp(id, hp);
//
//			break;

		case 7:
			System.out.print("Enter id : ");
			id = sc.nextInt();
			oneToOneRepository.removeCar(id);
			break;

		case 8:
			System.out.println("If you want to create a car first you need to create Engine");
			
			System.out.print("Enter Engine type : ");
			String type = sc.next();

			System.out.println();

			System.out.print("Enter hp : ");
			hp = sc.nextInt();
			
			System.out.println();

			System.out.print("Enter Car brand : ");
			String brand = sc.next();

			System.out.println();

			System.out.print("Enter price : ");
			price = sc.nextDouble();
			
			System.out.println();

			oneToOneRepository.addCar(type, hp, brand, price);
			
			break;

		default:

			break;
		}

	}
}
