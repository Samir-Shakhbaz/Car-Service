package com.example.carservice.controllers;

import com.example.carservice.modelss.Car;
import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Employee;
import com.example.carservice.modelss.Order;
import com.example.carservice.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Component
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    TireService tireService;

    @GetMapping("/customer-list")
    public String customerList(Model model) {
        final List<Customer> customerList = customerService.getAllCustomers();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("customerList", customerList);
        System.out.println("Customer List: " + customerList);
        return "customer-list";
    }

    @GetMapping("/new")
    public String showNewCustomerPage(Model model) {
        // Here a new (empty) Customer is created and then sent to the view
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new-customer";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer,
                               @ModelAttribute("car") Car car,
                               @RequestParam("car.make") String carMake,
                               @RequestParam("car.year") Integer carYear) {

        car.setMake(carMake);
        car.setYear(carYear);
        tireService.assignTires(car);
        tireService.assignWinterTires(car);
        customer.setCar(car);
        carService.saveCar(car); // saving the car entity first
        customerService.saveCustomer(customer);
        return "redirect:/customer/customer-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomerPage(@PathVariable(name = "id") Long id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "edit-customer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable(name = "id") Long id, @ModelAttribute("customer") Customer customer, Model model) {
        if (!id.equals(customer.getId())) {
            model.addAttribute("message",
                    "Cannot update, customer id " + customer.getId()
                            + " doesn't match id to be updated: " + id + ".");
            return "error-page";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customer/customer-list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/customer-list";
    }
}
