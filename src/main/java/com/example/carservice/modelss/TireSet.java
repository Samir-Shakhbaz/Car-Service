package com.example.carservice.modelss;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

//@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tire_set", schema = "car_service")
@Getter
@Setter
//@Builder

public class TireSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;

    @OneToOne
    private Car car;

    @ElementCollection
    private List<Tire>tireList;

    private List<Tire> thisCarTiresSummer;

    private List<Tire> thisCarTireWinter;

}
