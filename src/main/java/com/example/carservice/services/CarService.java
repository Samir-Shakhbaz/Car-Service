package com.example.carservice.services;

import com.example.carservice.modelss.Car;
import com.example.carservice.modelss.Customer;
import com.example.carservice.repositories.CarRepository;
import com.example.carservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public Car saveCar (Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCar (Long id) {return carRepository.findById(id).orElse(null);}

    public void deleteCar (Long id) { carRepository.deleteById(id);}

//    public Car getCarByCustomerId(Long id) {return carRepository.findById(id).orElse(null);}


}
