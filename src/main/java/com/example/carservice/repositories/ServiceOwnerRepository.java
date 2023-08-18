package com.example.carservice.repositories;

import com.example.carservice.modelss.ServiceOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOwnerRepository extends JpaRepository<ServiceOwner, Long> {
}
