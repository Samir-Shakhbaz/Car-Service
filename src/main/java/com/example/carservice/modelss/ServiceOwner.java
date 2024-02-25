package com.example.carservice.modelss;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "service-owner")
@Builder
@Getter
@Setter

public class ServiceOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private final String firstName = "Bill";
    private final String lastName = "Billinson";

    public String printOwner() {

        return firstName + " " + lastName;
    }
}

