package com.example.carservice;

import com.example.carservice.controllers.OrderController;
import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Order;
import com.example.carservice.repositories.*;
import com.example.carservice.services.CustomerService;
import com.example.carservice.services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(OrderController.class)
//@ActiveProfiles("test")
class OrderControllerTest {
    @Mock
    private OrderService orderService;

    @MockBean
    private CustomerService customerService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    CarRepository carRepository;

    @MockBean
    TireRepository tireRepository;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    OrderRepository orderRepository;

    @MockBean
    StorageRepository storageRepository;

    @Mock
    private Model model;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowOrderList() {
        // Set up test data
        List<Order> mockOrderList = new ArrayList<>();
        mockOrderList.add(new Order(1L, Customer.builder().id(8L).build(), null, null, "Status 1", false, false, false, false));
        mockOrderList.add(new Order(2L, null, null, null, "Status 2", false, false, false, false));
        when(orderService.getAllOrders()).thenReturn(mockOrderList);

        // Invoke the method
        String viewName = orderController.showOrderList(model);

        // Verify the behavior
        verify(model).addAttribute("orderList", mockOrderList);

        // Assert the view name or any other expected behavior
        assertEquals("order-list", viewName);
    }
}
