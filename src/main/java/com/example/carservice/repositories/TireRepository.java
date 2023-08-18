package com.example.carservice.repositories;

import com.example.carservice.modelss.Customer;
import com.example.carservice.modelss.Tire;
import com.example.carservice.modelss.TireStatus;
import com.example.carservice.modelss.TireType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TireRepository extends JpaRepository<Tire, Long> {

    List<Tire> findTiresByStatusAndType(TireStatus tireStatus, TireType tireType);

}

