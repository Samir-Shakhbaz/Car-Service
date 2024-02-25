package com.example.carservice.services;

import static org.junit.jupiter.api.Assertions.*;
import com.example.carservice.controllers.OrderController;
import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Employee;
import com.example.carservice.modelss.Order;
import com.example.carservice.repositories.*;
import com.example.carservice.services.CustomerService;
import com.example.carservice.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class OrderServiceUnitTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void test_saveNewOrder(){

        Customer customer = new Customer();
        Employee employee = new Employee();


        when(orderRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        Order actual = orderService.saveNewOrder(customer, employee, true, false, true, "as");

        assertEquals(true, actual.isToWinter());
        assertEquals("in progress", actual.getStatus());
        assertEquals(customer, actual.getCustomer());
    }



//    public Order saveNewOrder(Customer customer, Employee employee, boolean toWinter, boolean toSummer, boolean oilChange, String status){
//        Order order = Order.builder()
//                .customer(customer)
//                .employee(employee)
//                .toSummer(toSummer)
//                .toWinter(toWinter)
//                .oilChange(oilChange)
//                .status("in progress")
//                .build();
//
//        return orderRepository.save(order);
//    }

}