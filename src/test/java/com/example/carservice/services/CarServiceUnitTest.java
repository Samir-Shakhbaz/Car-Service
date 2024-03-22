package com.example.carservice.services;

import com.example.carservice.modelss.Car;
import com.example.carservice.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceUnitTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    CarService carService;

    @Test
    public void test_saveCar(){

        Car expected = new Car();
        when(carRepository.save(expected)).thenReturn(expected);

        Car actual = carService.saveCar(expected);

        assertEquals(expected, actual);
        verify(carRepository, times(1)).save(any());

    }

    @Test
    public void getAllCarsTest(){

    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


}