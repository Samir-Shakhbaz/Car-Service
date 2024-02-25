package com.example.carservice.services;

import com.example.carservice.modelss.*;
import com.example.carservice.repositories.CustomerRepository;
import com.example.carservice.repositories.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TireService {

    @Autowired
    Tire tire;

    @Autowired
    private TireRepository tireRepository;

    @Autowired
    private CustomerRepository customerRepository;

    Random random = new Random();

    Storage storage;

    public static List<Tire> summerTires() {

        List<Tire> summerTires = new ArrayList<>();
        for (Long i = 0L; i < 100; i++) {
            summerTires.add(new Tire(i, "GoodYear"));
        }
        return summerTires;
    }

    private List<Tire> winterTires() {
        List<Tire> winterTires = new ArrayList<>();
        for (Long x = 100L; x < 200; x++) {
            winterTires.add(new Tire(x, "GoodYear"));
        }
        tireRepository.saveAll(winterTires);
        return winterTires;
    }

    public void initializeTires() {
        for (int x = 0; x < 100; x++) {
            tireRepository.save(Tire.builder().make("BridgeStone").type(TireType.SUMMER).status(TireStatus.NEW).build());
            tireRepository.save(Tire.builder().make("Taganka").type(TireType.WINTER).status(TireStatus.NEW).build());
        }
    }

    public List<Tire> generateWinterTires() {
        List<Tire> winterTires = new ArrayList<>();
        for (Long x = 100L; x < 200; x++) {
            winterTires.add(new Tire(x, "GoodYear"));
        }
        tireRepository.saveAll(winterTires);
        return winterTires;
    }

    public void assignTires(Car car) {

        List<Tire> tires = tireRepository.findTiresByStatusAndType(TireStatus.NEW, TireType.SUMMER);
        if (tires.isEmpty()) {
            initializeTires();
            tires = tireRepository.findTiresByStatusAndType(TireStatus.NEW, TireType.SUMMER);
        }
        car.setTireList(new ArrayList<>());
        for (int i = 0; i < 4; i++) {
            int id = random.nextInt(tires.size());
            Tire tire = tires.get(id);
            tires.remove(id);
            System.out.println(tire);
            car.getTireList().add(tire);
            tire.setStatus(TireStatus.INSTALLED);
            tireRepository.save(tire);
        }

    }

    public void assignWinterTires(Car car) {
        List<Tire> tires = tireRepository.findTiresByStatusAndType(TireStatus.NEW, TireType.WINTER);
        if (tires.isEmpty()) {
            initializeTires();
            tires = tireRepository.findTiresByStatusAndType(TireStatus.NEW, TireType.WINTER);
        }

        for (int i = 0; i < 4; i++) {
            int id = random.nextInt(tires.size());
            Tire tire = tires.get(id);
            tires.remove(id);
            System.out.println(tire);
            car.getTireList().add(tire);
            tire.setStatus(TireStatus.BOOKED);
            tireRepository.save(tire);
        }
    }

    public void removeTiresNow(Car car) {

        List<Tire> tires = tireRepository.findTiresByStatusAndType(TireStatus.INSTALLED, TireType.SUMMER);

        for (int i = 0; i < tires.size(); i++) {
            Tire tire = tires.get(i);
            System.out.println(tire);
            car.getTireList().remove(tire);
            tire.setStatus(TireStatus.BOOKED);
            tireRepository.save(tire);
        }
    }

    public void putWinterTires(Car car) {

        List<Tire> tires = tireRepository.findTiresByStatusAndType(TireStatus.NEW, TireType.WINTER);

        for (int i = 0; i < tires.size(); i++) {
            Tire tire = tires.get(i);
            System.out.println(tire);
            car.getTireList().add(tire);
            tire.setStatus(TireStatus.INSTALLED);
            tireRepository.save(tire);
        }
    }


//    //EXPERIMENTO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    public List<Long> removeAssignedTires(Car car) {
//        List<Tire> assignedTires = car.getTireList();
//        List<Tire> allTires = tireRepository.findAll();
//        List<Long> removedTireIds = new ArrayList<>();
//
//        for (Tire tire : assignedTires) {
//            allTires.add(tire);
//            removedTireIds.add(tire.getTireId());
//            System.out.println("Removed tire with ID: " + tire.getTireId());
//        }
//
//        assignedTires.clear();
//
//        return removedTireIds;
//    }


//    public void removeTires(Car car) {
//
//        Customer customer = customerRepository.findById(car.getId()).orElseThrow();
//
//        List<Tire> tiresToRemove = customer car.getTireList();
//
//        for (Tire tire : tiresToRemove) {
//            tiresToRemove.clear();
//
////            storage.getSummerTires().add(tire);
//
//            System.out.println(tire.getTireId());
//        }
//    }


    //THIS WORKED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void removeAssignedTires(Car car) {
        List<Tire> assignedTires = car.getTireList();
        List<Tire> allTires = tireRepository.findAll();

        for (Tire tire : assignedTires) {
            allTires.add(tire);
            System.out.println("Removed tire with ID: " + tire.getTireId());
        }

        assignedTires.clear();
    }


//    public void printTires() {
//        System.out.print("[");
//        for (int i = 0; i < getSummerTires().size(); i++) {
//            Tire tire = getSummerTires().get(i);
//            System.out.print(tire.getTireId() + ",");
//        }
//        System.out.println("]");
//
//        System.out.print("[");
//        for (int i = 0; i < getWinterTires().size(); i++) {
//            Tire tire = getWinterTires().get(i);
//            System.out.print(tire.getTireId() + ",");
//        }
//        System.out.println("]");
//    }

    private Optional<Tire> getSummerTires(Long id) {
        return tireRepository.findById(id);
    }

    private Optional<Tire> getWinterTires(Long id) {
        return tireRepository.findById(id);
    }

//    public List<Tire> getAllTires() {
//        return tireRepository.findAll();
//    }

    public List<Tire> getAllTires(Sort sort) {
        return tireRepository.findAll(sort);
    }
}
