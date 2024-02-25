package com.example.carservice.services;

import com.example.carservice.modelss.*;
import com.example.carservice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){return employeeRepository.findAll();}

    public List <Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployee(Long id) {return employeeRepository.findById(id).orElse(null);}

    public List<Employee> getAvailableEmployees() {
     /*   List<Employee> allEmployees = getAllEmployees();*/

        return getAllEmployees().stream()
                .filter(employee -> employee.getOrders().isEmpty())
                .collect(Collectors.toList());
    }

    public void employeeStatus() {
        List<Employee> employeeList = getAllEmployees();

        for (Employee employee : employeeList) {
            if (!employee.getOrders().isEmpty()) {
                employee.setStatus("Assigned");
            } else {
                employee.setStatus("Available");
            } employeeRepository.save(employee);
        }
    }

    public void initializeEmployeeList() {
        List<String> employeeList = new ArrayList<>();
        employeeRepository.save(Employee.builder().firstName("Jerry").lastName("Mouse").build());
        employeeRepository.save(Employee.builder().firstName("Nick").lastName("Brown").build());
        employeeRepository.save(Employee.builder().firstName("Moe").lastName("Johnson").build());
        employeeRepository.save(Employee.builder().firstName("Larry").lastName("Wilson").build());
        employeeRepository.save(Employee.builder().firstName("Curly").lastName("Hunter").build());
        employeeRepository.save(Employee.builder().firstName("Shemp").lastName("Michaels").build());
//        employeeList.add("John Smith");
//        employeeList.add("Jane Doe");
//        employeeList.add("Michael Johnson");
//        employeeRepository.saveAll();
        System.out.println(employeeList);
        // Add more employee names as needed
    }
}
