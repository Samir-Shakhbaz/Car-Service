package com.example.carservice.controllers;

import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Employee;
import com.example.carservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Component
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee-list")
    public String customerList(Model model) {
        // Here we call the service to retrieve all the customers
        final List<Employee> employeeList = employeeService.getAllEmployees();
        // Once the customers are retrieved, we can store them in model and return it to the view
        model.addAttribute("employeeList", employeeList);
        System.out.println("Employee List: " + employeeList);
        return "employee-list";
    }
}
