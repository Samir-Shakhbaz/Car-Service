package com.example.carservice.modelss;


import jakarta.persistence.*;
import lombok.*;

import org.springframework.stereotype.Component;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tires", schema = "car_service")
@Builder
@Getter
@Setter

@Component

public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long tireId;
    private String make;

    private TireType type;

    private TireStatus status;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Tire(Long tireId, String make, Storage storage) {
        this.tireId = tireId;
        this.make = make;
//        this.storage = storage;
    }

    public Tire(Long tireId, String make) {
        this.tireId = tireId;
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

}
