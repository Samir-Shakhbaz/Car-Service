package com.example.carservice;
import java.util.*;

import com.example.carservice.controllers.TireController;
import com.example.carservice.modelss.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
//@Configuration
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CarService2023Application {

	@Bean
	public Order order() {
		return new Order();
	}

	public static void main(String[] args) {
		SpringApplication.run(CarService2023Application.class, args);

//		int [] array = new int[3];
//		array[0] = 7;
//		array[1] = 9;
//		array[2] = 3;
//
//		int max = array [0];
//		for(int i = 0; i< array.length; i++){
//			if(array  [i] > max){
//				max = array[i];
//			}
//		}
//
//		double average = 0;
//		int sum = 0;
////		for (int j : array)
//		for(int i = 0; i < array.length; i++){
//			sum += array [i];
//			average = (double) sum/array.length;
//		}
//
//		System.out.println(max);
//
//		System.out.println(array[1]);
//
//		System.out.println(average);


//		TireController tireController = new TireController();
//		tireController.removeTiresNow();

//		Poker poker = new Poker();
//		poker.shuffleCards();

//		Storage storage = new Storage();
//
//		List<Car> cars = Car.createCars(storage);
//
//
//		List<Customer> customers = Customer.createCustomers(cars);
//
//
//		List<Employee> employees = Employee.createEmployees();

//        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//
//
//        System.out.println(customers.get(0));

//		Order order = new Order(1L, customers.get(0), employees.get(0), storage, "needed");
//        System.out.println("-----------------------------------------");
//        order.fulfill();
//
//
//        System.out.println(customers.get(0));
//
//
//        List<Order> orders = new ArrayList<>();
////        List<Customer> customers = new ArrayList<>();
////        List<Employee> employees = new ArrayList<>();
//        int ordNum = 1;
//        for (int i = 0; i < customers.size(); i++) {
//            orders.add(new Order(ordNum, customers.get(i), employees.get(2), storage, "needed"));
//            ordNum++;
//
//        }
//        System.out.println(orders);
//
//        for (Order o : orders) {
//            System.out.println(o.getStatus());
//        }
//
//        for (Order o : orders) {
//            o.fulfill();
//        }
//
//        for (Order o : orders) {
//            System.out.println(o.getStatus());
//        }
//
//        for (Order o : orders) {
//            o.fulfill();
//        }

//        Interaction interaction = new Interaction();
//        interaction.enterName();
//        interaction.serviceNeeded();
//
//		System.out.println("Please, enter customer's first name:");
//		Scanner scanner = new Scanner(System.in);
//		String customerFirstName = scanner.next();
//
//		System.out.println("Please, enter customer's last name:");
//		String customerLastName = scanner.next();
//
//		System.out.println("Please, enter customer's car:");
//		String customerCar = scanner.next();
//
//
//		serviceNeeded();
//
//
//
////            String serviceAnswer = scanner.next();
//
//		String confirm = scanner.next();
//
//		if (confirm.equalsIgnoreCase("y")) {
//
////			order.fulfill();
//		}
//
//
//		if (confirm.equalsIgnoreCase("n")) {
//
//			serviceNeeded();
//
////                System.out.println("What service needed? Please, choose one below:" +
////                        "\n1. change winter tires to summer tires" +
////                        "\n2. change summer tires to winter");
//		}

	}



	public static void serviceNeeded(){
		Scanner scanner = new Scanner(System.in);

		boolean finished = false;
		while(!finished) {
			System.out.println("What service needed? Please, choose one below:" +
					"\n1. change winter tires to summer tires" +
					"\n2. change summer tires to winter" +
					"\n3. return to the previous page");

			int serviceNeeded = scanner.nextInt();
			if (serviceNeeded == 1) {
				System.out.println("do you want to change winter tires to summer tires? Please, type 'y' for 'yes' or 'n' for 'no': ");
				String answer = scanner.next();
				if(answer.equalsIgnoreCase("y")){
					System.out.println("thank you");
					finished = true;
				}
			} else {
				System.out.println("do you want to change summer tires to winter tires? Please, type 'y' for 'yes' or 'n' for 'no': ");
			}
		}
	}

}

