package com.example.carservice.modelss;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
//@Builder
@Getter
@Setter
@Component
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String make;
    private Integer year;
    private String model;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    //    @JoinColumn (name = "customer_id")
    private Customer customer;
    @OneToMany
    private List<Tire> tireList;

    public Car(Long id, String make, String model, Integer year, Storage storage, List<Tire> tireList) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
//        this.storage = storage;
        this.tireList = tireList;
    }

    public static List<Car> createCars(Storage storage) {
        List<Car> cars = new ArrayList<>();
        for (Long i = 0L; i < 15; i++) {
            cars.add(new Car(i));
        }
//        System.out.println(cars);
        System.out.println(cars.size());

        //CHANGE RANDOM TIRES

        Random random = new Random();
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            System.out.println(car);
            for (int i = 0; i < 4; i++) {
                int id = random.nextInt(storage.getSummerTires().size());
                Tire tire = storage.getSummerTires().get(id);
                storage.getSummerTires().remove(id);
                System.out.println(tire);
                car.getTireList().add(tire);

            }
        }
        return cars;
    }

    public Car(Long id) {
        this.id = id;
        this.tireList = new ArrayList<>();
    }

    public List<Tire> getTireList() {
        return tireList;
    }

    public Car(String make, String model, Integer year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make){
        this.make = make;
    }

    public String getModel(){return model;}

    public void setModel(String model){this.model = model;}

    public Integer getYear(){return year;}

    public void setYear(Integer year){this.year = year;}

    public List<Tire> getInstalledTires(){
        List<Tire> installedTires = new ArrayList<>();
        for(Tire tire: tireList){
            if(tire.getStatus() == TireStatus.INSTALLED){
                installedTires.add(tire);
            }
        }
        return installedTires;
    }
//
    public List<Tire> getBookedTires(){
        return tireList.stream().filter(tire -> tire.getStatus() == TireStatus.BOOKED).toList();
    }

    public List<Tire> getSummerTires(){
        return tireList.stream().filter(tire -> tire.getType() == TireType.SUMMER).toList();
    }

    public List<Tire> getWinterTires(){
        return tireList.stream().filter(tire -> tire.getType() == TireType.WINTER).toList();
    }

//    @Override
//    public String toString() {
//        return "Car{" +
//                "id=" + id +
//                ", make='" + make + '\'' +
//                ", model='" + model + '\'' +
//                ", year=" + year +
//                ", tireList=" + tireList +
//                '}';
//    }
}
