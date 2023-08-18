package com.example.carservice.modelss;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "storage")
@Builder
@Getter
@Setter
@Component
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Tire> summerTires;
    @OneToMany
    private List<Tire> winterTires;

    @OneToMany
    private List<Tire> tires;


////    @OneToMany
//    private Map<Car, List<Tire>> thisCarTiresSummer;
////    @OneToMany
//    private Map<Car, List<Tire>> thisCarTiresWinter;

    public void addTires(List<Tire> tires) {
        if (this.tires == null) {
            this.tires = new ArrayList<>();
        }
        this.tires.addAll(tires);
    }

    public static List<Tire> summerTires() {

        List<Tire> summerTires = new ArrayList<>();
        for (Long i = 0L; i < 100; i++) {
            summerTires.add(new Tire(i, "GoodYear"));
        }
        return summerTires;
    }

    public static List<Tire> winterTires() {
        List<Tire> winterTires = new ArrayList<>();
        for (Long x = 100L; x < 200; x++) {
            winterTires.add(new Tire(x, "GoodYear"));
        }
        return winterTires;
    }

    public void printTires() {
        System.out.print("[");
        for (int i = 0; i < getSummerTires().size(); i++) {
            Tire tire = getSummerTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");

        System.out.print("[");
        for (int i = 0; i < getWinterTires().size(); i++) {
            Tire tire = getWinterTires().get(i);
            System.out.print(tire.getTireId() + ",");
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "Storage{" +
                "summerTires=" + summerTires +
                ", winterTires=" + winterTires +
//                ", thisCarTiresSummer=" + thisCarTiresSummer +
//                ", thisCarTiresWinter=" + thisCarTiresWinter +
                '}';
    }
}
