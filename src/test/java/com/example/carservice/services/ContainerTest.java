package com.example.carservice.services;

import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Employee;
import com.example.carservice.modelss.Order;
import com.example.carservice.repositories.CustomerRepository;
import com.example.carservice.repositories.EmployeeRepository;
import com.example.carservice.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.AdditionalAnswers;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.containers.wait.strategy.Wait;


import java.time.Duration;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AutoConfigureMockMvc
@Testcontainers
public class ContainerTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.34"))
            .withDatabaseName("car_servic")
            .withUsername("root")
            .withPassword("")
            .waitingFor(Wait.forListeningPort().withStartupTimeout(Duration.ofMinutes(10)));

//    static {
//        mysql.setPortBindings(Arrays.asList("3355:3306"));
//        mysql.waitingFor(Wait.forListeningPort().withStartupTimeout(Duration.ofMinutes(10)));
//    }

    @BeforeAll
    static void beforeAll() {
        mysql.start();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test_saveNewOrder(){

        Customer customer = new Customer();
        customer = customerRepository.save(customer);

        Employee employee = new Employee();
        employee = employeeRepository.save(employee);


//        when(orderRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        Order actual = orderService.saveNewOrder(customer, employee, true, false, true, "as");

        assertEquals(true, actual.isToWinter());
        assertEquals("in progress", actual.getStatus());
        assertEquals(customer, actual.getCustomer());
    }

}
