package com.example.carservice.services;

import com.example.carservice.modelss.Employee;
import com.example.carservice.modelss.Order;
import com.example.carservice.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void test_employeeStatus(){

        Employee employee = new Employee();
        employee.setStatus("test");

        Order order = new Order();

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        employee.setOrders(orders);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

    employeeService.employeeStatus();

    assertEquals("Assigned", employee.getStatus());
    verify(employeeRepository, times(1)).findAll();
    verify(employeeRepository, times(1)).save(any());



    }

    @Test
    public void test_employeeStatus_Available(){

        Employee employee = new Employee();
        employee.setStatus("test");
        employee.setOrders(new ArrayList<>());

//        Order order = new Order();

//        List<Order> orders = new ArrayList<>();
////        orders.add(order);
//        employee.setOrders(orders);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        employeeService.employeeStatus();

        assertEquals("Available", employee.getStatus());
        verify(employeeRepository, times(1)).findAll();
        verify(employeeRepository, times(1)).save(any());



    }

//
////    public void employeeStatus() {
////        List<Employee> employeeList = getAllEmployees();
////
////        for (Employee employee : employeeList) {
////            if (!employee.getOrders().isEmpty()) {
////                employee.setStatus("Assigned");
////            } else {
////                employee.setStatus("Available");
////            } employeeRepository.save(employee);
////        }
////    }
//
}