package com.example.carservice.services;

import com.example.carservice.modelss.Customer;
import com.example.carservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@ComponentScan
//@Transactional(readOnly = true)
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {return customerRepository.findById(id).orElse(null);}

    public void deleteCustomer(Long id) { customerRepository.deleteById(id);}

}

