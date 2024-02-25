package com.example.carservice.modelss;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "employees")
@Builder
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String status;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public Long getOrderId() {
        if (orders != null && !orders.isEmpty()) {
            return orders.get(0).getId(); // Assuming you want to retrieve the ID of the first order
        }
        return null;
    }

    public static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            employees.add(new Employee());
        }
        System.out.println(employees.size());
        return employees;
    }

    public Employee(String firstName, String phoneNumber) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public List<String> initializeEmployeeList() {
        List<String> employeeList = new ArrayList<>();
        employeeList.add("John Smith");
        employeeList.add("Jane Doe");
        employeeList.add("Michael Johnson");
        System.out.println(employeeList);
        // Add more employee names as needed
        return employeeList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

