package com.example.carservice.modelss;

//import javax.persistence.*




import jakarta.persistence.*;
import lombok.*;

//import org.springframework.data.annotation.Id;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Builder
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

//    @OneToOne
//    @JoinColumn(name = "car_id")
//    private Car car;

//    private long creditCard = 1111222233334444l;


    public Customer (Long id, String firstName, String lastName, Car car){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.car = car;
    }

    @OneToOne (cascade = CascadeType.ALL)
    private Car car;
    // other properties

    @OneToMany (mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public static List<Customer> createCustomers(List<Car> cars) {

        List<Customer> customers = new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            customers.add(new Customer(c));
        }

        System.out.println("Total number of customers is: " + customers.size());


        Random random = new Random();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            for (int j = 0; j < 1; j++) {
                int id = random.nextInt(cars.size());
                Car car = cars.get(id);
                cars.remove(id);
//                customer.setCar(car);
                System.out.println("Info about customer's car " +  car);
            }
        }
        return customers;
    }

    public Customer(int c) {
    }

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", car=" + car +
//                '}';
//    }


}
