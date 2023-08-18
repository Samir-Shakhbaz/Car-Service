package com.example.carservice.controllers;

import com.example.carservice.modelss.*;
import com.example.carservice.services.CustomerService;
import com.example.carservice.services.EmployeeService;
import com.example.carservice.services.OrderService;
import com.example.carservice.services.TireService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@ComponentScan
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CustomerService customerService;

    @Autowired
    TireService tireService;

    @Autowired
    OrderService orderService;

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/new")
    public String showNewOrderPage(HttpSession session,
                                   @RequestParam(value = "customerId", required = false) Long customerId,
                                   Model model) {

        if (customerId == null) {
            return "redirect:/customer/customer-list";
        }
        Customer customer = customerService.getCustomer(customerId);

        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("customer", customer);

        List<Employee> employeeList = employeeService.getAllEmployees();
        if (employeeList.isEmpty()) {
            employeeService.initializeEmployeeList();
            employeeList = employeeService.getAllEmployees();

        }
        model.addAttribute("employeeList", employeeList);
        System.out.println(employeeList);
        return "new-order";
    }

    @GetMapping("/order-list")
    public String showOrderList(Model model) {
        List<Order> orderList = orderService.getAllOrders();
        for (Order order : orderList) {
            String status = order.getStatus();
            order.setStatus(status);
            System.out.println("Status" + order.getStatus());

        }
        model.addAttribute("orderList", orderList);
        System.out.println("Order List: " + orderList);
        return "order-list";
    }

    @GetMapping("/filled-order/{orderId}")
    public String showFilledOrder(Model model, @PathVariable Long orderId) {
        Order order = orderService.getById(orderId);
        model.addAttribute("order", order);
        return "filled-order";
    }

    @PostMapping("/completed/{orderId}")
    public String markOrderAsCompleted(Model model, @PathVariable Long orderId) {
        Order order = orderService.getById(orderId);
        order.setCompleted(true);
        order.setStatus("completed");
        if(order.getCompletedAt() == null){
            order.setCompletedAt(LocalDateTime.now());
            order.getEmployee().setStatus("Available");
        }

        orderService.getById(orderId);//nichego ne delaet
        orderService.saveOrder(order);
        model.addAttribute("order", order);
        return "completed";
    }

    @GetMapping("/completed/{orderId}")
    public String goToCompletedOrder(Model model, @PathVariable Long orderId) {
        Order order = orderService.getById(orderId);
        order.setCompleted(true);
        order.setStatus("completed");
        if(order.getCompletedAt() == null){
            order.setCompletedAt(LocalDateTime.now());
        }
        orderService.getById(orderId);//nichego ne delaet
        orderService.saveOrder(order);
        model.addAttribute("order", order);
        return "completed";
    }


    @PostMapping("/done")
    public String saveCompletedBox(HttpSession session,
                                 @RequestParam(required = false) boolean oilChange,
                                 @RequestParam(required = false) boolean toWinter,
                                 @RequestParam(required = false) boolean toSummer,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(value = "customerId", required = false) Long customerId,
                                 @RequestParam(value = "employeeId", required = false) Long employeeId,
                                 Model model) {

        System.out.println("customerId: " + customerId);
        System.out.println("employeeId: " + employeeId);

        Customer customer = customerService.getCustomer(customerId);
        Employee employee = employeeService.getEmployee(employeeId);

        if (employee != null) {
            Order order = orderService.saveNewOrder(customer, employee, toWinter, toSummer, oilChange, status);
            order.setCompletedAt(LocalDateTime.now());
            List<Employee> employeeList = employeeService.getAvailableEmployees(); /*PROVERIT'*/
            employeeService.employeeStatus();
//            employeeList.remove(employee);
            model.addAttribute("employeeList", employeeList);
            model.addAttribute("order", order);
            return "redirect:/order/completed/" + order.getId();
        } else {
            System.out.println("ERROR");
            return null;
        }

    }

    @PostMapping("/save")
    public String saveCheckboxes(HttpSession session,
                                 @RequestParam(required = false) boolean oilChange,
                                 @RequestParam(required = false) boolean toWinter,
                                 @RequestParam(required = false) boolean toSummer,
                                 @RequestParam(required = false) String status,
                                 @RequestParam(value = "customerId", required = false) Long customerId,
                                 @RequestParam(value = "employeeId", required = false) Long employeeId,
                                 Model model) {

        System.out.println("customerId: " + customerId);
        System.out.println("employeeId: " + employeeId);

        Customer customer = customerService.getCustomer(customerId);
        Employee employee = employeeService.getEmployee(employeeId);
        if (employee != null) {
            Order order = orderService.saveNewOrder(customer, employee, toWinter, toSummer, oilChange, status);
            List<Employee> employeeList = employeeService.getAvailableEmployees(); /*PROVERIT'*/
            employeeService.employeeStatus();
//            employeeList.remove(employee);
            model.addAttribute("employeeList", employeeList);
            model.addAttribute("order", order);
            return "redirect:/order/filled-order/" + order.getId();
        } else {
            System.out.println("ERROR");
            return null;
        }
    }

    @PostMapping("/change")
    private List<Long> getTireIdsToRemove(Car car) {
        List<Long> tireIds = new ArrayList<>();
        for (Tire tire : car.getTireList()) {
            tireIds.add(tire.getTireId());
        }
        return tireIds;
    }

    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable(name = "id") Long id, Employee employee) {
        Order deletedOrder = orderService.deleteOrder(id);
//        List<Employee> employeeList = employeeService.getAvailableEmployees(); /*PROVERIT'*/
        employeeService.employeeStatus();
//        employeeList.add(employee);
        return "redirect:/order/order-list";
    }


}
