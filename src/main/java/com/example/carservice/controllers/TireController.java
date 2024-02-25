package com.example.carservice.controllers;

import com.example.carservice.modelss.*;
import com.example.carservice.repositories.CarRepository;
import com.example.carservice.repositories.StorageRepository;
import com.example.carservice.repositories.TireRepository;
import com.example.carservice.services.CarService;
import com.example.carservice.services.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/tire")
public class TireController {

    @Autowired
    TireService tireService;

    @Autowired
    TireRepository tireRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    CarService carService;

//    public void removeTiresNow() {
//            Long carId = 1L;
//        Optional<Car> carOptional = carRepository.findById(carId);
//        Car car = carOptional.orElse(new Car());
//
//        Long storageId = 2L;
//        Storage storage = storageRepository.findById(storageId).orElse(new Storage());
//
//        List<Tire> carTireList = car.getTireList();
//        List<Tire> storageTireList = storage.getTires();
//
//        for (int i = 0; i < 4; i++) {
//            if (!carTireList.isEmpty()) {
//                // Getting the tire at index 0
//                Tire tire = carTireList.get(0);
//                // Removing the tire at index 0
//                carTireList.remove(0);
//                // Adding the removed tire to the summer tires storage
//                storageTireList.add(tire);
//                System.out.println("THIS IS THE LIST" + tire);
//            } else {
//                // Handle the case when there are no more tires in the car
//                // Break the loop or perform alternative actions
//                break;
//            }
//        }
//
//        // Save the updated car and storage objects if necessary
//        carRepository.save(car);
//        storageRepository.save(storage);
//    }

//    @GetMapping("/winter-tires-list")
//    public String winterTiresList(Model model) {
//        List<Tire> allTiresList = tireService.getAllTires();
//
//        // If the winter tire list is empty, populate it with winter tires
//        if (allTiresList.isEmpty()) {
//            tireService.initializeTires();
//            allTiresList = tireService.getAllTires();
//        }
//
//        System.out.println("Winter Tires List Size: " + allTiresList.size()); // Add this line
//
//        model.addAttribute("allTiresList", allTiresList);
//        return "winter-tires-list";
//    }

    @GetMapping("/winter-tires-list")
    public String winterTiresList(Model model, @RequestParam(defaultValue = "tireId-asc") String[] sort) {
        List<Sort.Order> orders = new ArrayList<>();

        for (String sortOrder : sort) {
            String[] _sort = sortOrder.split("-");
            if (_sort.length > 1) {
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            } else {
                //
                //  to ascending order if no direction is specified
                orders.add(new Sort.Order(Sort.Direction.ASC, _sort[0]));
            }
        }

        List<Tire> allTiresList = tireService.getAllTires(Sort.by(orders));

        model.addAttribute("allTiresList", allTiresList);
        return "winter-tires-list";
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equalsIgnoreCase("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }




}
