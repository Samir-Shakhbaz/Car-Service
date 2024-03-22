package com.example.carservice.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.carservice.modelss.Car;
import com.example.carservice.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarService carService;

    @Test
    public void saveCarTest(){
        Car car = new Car();
        when(carRepository.save(any(Car.class))).thenReturn(car);
        Car savedCar = carService.saveCar(car);

        assertNotNull(savedCar);
        assertEquals(car, savedCar);
        verify(carRepository).save(car);

    }

    //this is a way to test for null if null check exists in the source code
//    @Test
//    public void saveCarWithNullShouldThrowExceptionTest() {
//        try {
//            carService.saveCar(null);
//            fail("Expected an IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            // Test passes if this block is reached
//        }
//
//        verify(carRepository, never()).save(any(Car.class));
//    }

    @Test
    public void saveNullCarTest() {
        when(carRepository.save(null)).thenThrow(new IllegalArgumentException("Car must not be null"));

        try {
            carService.saveCar(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // The test passes if this block is reached
            // Optionally, you can assert details about the exception, like its message
            assertEquals("Car must not be null", e.getMessage());
        }

        verify(carRepository).save(null); // Verifying that the save method was indeed called with null
    }



}