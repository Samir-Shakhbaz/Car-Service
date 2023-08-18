package com.example.carservice.repositories;

import com.example.carservice.modelss.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
