package com.example.carservice.repositories;

import com.example.carservice.modelss.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository <Car, Long>{

}
