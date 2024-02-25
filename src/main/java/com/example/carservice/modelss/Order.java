package com.example.carservice.modelss;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Builder
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    private String serviceNeeded;

    private String status;

    private boolean oilChange;
    private boolean toWinter;
    private boolean toSummer;

    private boolean completed;

    public Order(Sort.Direction sortDirection, String s) {
    }

//    public void signoff(ServiceOwner serviceOwner) {
//
//        this.status = "signed by: " + serviceOwner.printOwner();
//
//    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", employee=" + employee +
                ", serviceNeeded='" + serviceNeeded + '\'' +
                ", status='" + status + '\'' +
                ", oilChange=" + oilChange +
                ", toWinter=" + toWinter +
                ", toSummer=" + toSummer +
                '}';
    }
}
