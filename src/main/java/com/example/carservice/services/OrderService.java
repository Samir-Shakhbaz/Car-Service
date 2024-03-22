package com.example.carservice.services;

import com.example.carservice.modelss.*;
import com.example.carservice.repositories.OrderRepository;
//import com.example.carservice.repositories.StorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Component
public class OrderService {

//   @Autowired
//   Order order;


//    @Autowired
//    StorageRepository storageRepository;

    @Autowired
    Tire tire;

    @Autowired
    Car car;

    @Autowired
    OrderRepository orderRepository;

    private Storage storage;


    public Order deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return null;
    }

    public Order saveNewOrder(Customer customer, Employee employee, boolean toWinter, boolean toSummer, boolean oilChange, String status) {
        Order order = Order.builder()
                .customer(customer)
                .employee(employee)
                .toSummer(toSummer)
                .toWinter(toWinter)
                .oilChange(oilChange)
                .status("in progress")
                .build();

        return orderRepository.save(order);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }



    public void removeTires(List<Tire> remove, List<Tire> set, Map<Car,
            List<Tire>> removeMap, Map<Car, List<Tire>> setMap) {
        for (int i = 0; i < 4; i++) {
            //getting tire at index 0;
            Tire tire = car.getTireList().get(0);
            //removing tire at index 0;
            car.getTireList().remove(0);
            //adding removed tire to the summer tires storage
            remove.add(tire);
            //if there is info about this car in the storage
            if (removeMap.containsKey(car)) {
                //we pull tire list on this car from the storage
                List<Tire> tireList = removeMap.get(car);
                //adding
                tireList.add(tire);
                //adding this list of tires to the 'register'
                removeMap.put(car, tireList);
            } else {
                //if this car has no record in the storage
                //we initialize a new tire list for this car
                List<Tire> tireList = new ArrayList<>();
                //add tire to the list
                tireList.add(tire);
                //and put it in the storage
                removeMap.put(car, tireList);
            }
            System.out.println("FROM LINE 66" + tire);
        }
        //car w/o tires


        if (setMap.containsKey(car)) {
            List<Tire> tireList = setMap.get(car);
            for (int i = 0; i < 4; i++) {
                //then we pull the tires

                Tire tire = tireList.remove(0);
                setMap.put(car, tireList);
                car.getTireList().add(tire);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                Tire tire = set.remove(0);
                car.getTireList().add(tire);
            }
        }
    }

    public Order getById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }

    public List<Order> getAllOrders() { return orderRepository.findAll(); }

//    public void fulfill() {
////        if (this.status.equals("closed")) {
////            System.out.println("This order is already closed");
////            return;
////        }
//
//        if (storage.getThisCarTiresWinter() != null) {
//            removeTires(storage.getSummerTires(), storage.getWinterTires(), storage.getThisCarTiresSummer(), storage.getThisCarTiresWinter());
//            for (int i = 0; i < 4; i++) {
//                //getting tire at index 0;
//                Tire tire = car.getTireList().get(0);
//                //removing tire at index 0;
//                car.getTireList().remove(0);
//                //adding removed tire to the summer tires storage
//                storage.getSummerTires().add(tire);
//                //if there is info about this car in the storage
//                if (storage.getThisCarTiresSummer().containsKey(car)) {
//                    //we pull tire list on this car from the storage
//                    List<Tire> tireList = storage.getThisCarTiresSummer().get(car);
//                    //adding
//                    tireList.add(tire);
//                    //adding this list of tires to the 'register'
//                    storage.getThisCarTiresSummer().put(car, tireList);
//                } else {
//                    //if this car has no record in the storage
//                    //we initialize a new tire list for this car
//                    List<Tire> tireList = new ArrayList<>();
//                    //add tire to the list
//                    tireList.add(tire);
//                    //and put it in the storage
//                    storage.getThisCarTiresSummer().put(car, tireList);
//                }
//                System.out.println("FROM LINE 66" + tire);
//            }
//            //car w/o tires
//
//
//            if (storage.getThisCarTiresWinter().containsKey(car)) {
//                List<Tire> tireList = storage.getThisCarTiresWinter().get(car);
//                for (int i = 0; i < 4; i++) {
//                    //then we pull the tires
//
//
//                    Tire tireWinter = tireList.remove(0);
//                    storage.getThisCarTiresWinter().put(car, tireList);//skolko ostalos'
//                    car.getTireList().add(tireWinter);
//                }
//            } else {
//                for (int i = 0; i < 4; i++) {
//                    Tire tireWinter = storage.getWinterTires().remove(0);
////                    List<Tire> tireList = new ArrayList<>();
////                    tireList.add(tireWinter);
////                storage.getThisCarTiresWinter().put(car, tireList);
//                    car.getTireList().add(tireWinter);
//                }
//            }
//        }
////        if winter tires were on a car
//        else {
//            removeTires(storage.getWinterTires(), storage.getSummerTires(), storage.getThisCarTiresWinter(), storage.getThisCarTiresSummer());
//            for (int i = 0; i < 4; i++) {
//                //getting tire at index 0;
//                Tire tire = car.getTireList().get(0);
//                //removing tire at index 0;
//                car.getTireList().remove(0);
//                //adding removed tire to the winter tires storage
//                storage.getWinterTires().add(tire);
//                //if there is info about this car in the storage
//                if (storage.getThisCarTiresWinter().containsKey(car)) {
//                    //we pull tire list on this car from the storage
//                    List<Tire> tireList = storage.getThisCarTiresWinter().get(car);
//                    //adding
//                    tireList.add(tire);
//                    //adding this list of tires to the 'register'
//                    storage.getThisCarTiresWinter().put(car, tireList);
//                } else {
//                    //if this car has no record in the storage
//                    //we initialize a new tire list for this car
//                    List<Tire> tireList = new ArrayList<>();
//                    //add tire to the list
//                    tireList.add(tire);
//                    //and put it in the storage
//                    storage.getThisCarTiresWinter().put(car, tireList);
//                }
//                System.out.println("CHANGE TO SUMMER-----------------------" + tire);
//            }
//            //car w/o tires
//
//
//            if (storage.getThisCarTiresSummer().containsKey(car)) {
//                List<Tire> tireList = storage.getThisCarTiresSummer().get(car);
//                for (int i = 0; i < 4; i++) {
//                    //then we pull the tires
//
//
//                    Tire tireSummer = tireList.remove(0);
//                    storage.getThisCarTiresSummer().put(car, tireList);//skolko ostalos'
//                    car.getTireList().add(tireSummer);
//                }
//            } else {
//                for (int i = 0; i < 4; i++) {
//                    Tire tireSummer = storage.getSummerTires().remove(0);
////                    List<Tire> tireList = new ArrayList<>();
////                    tireList.add(tireSummer);
////                storage.getThisCarTiresWinter().put(car, tireList);
//                    car.getTireList().add(tireSummer);
//                }
//            }
//
//        }
//    }

//    public void signoff(ServiceOwner serviceOwner) {
//
//        this.status = "signed by: " + serviceOwner.printOwner();
//
//    }

}
