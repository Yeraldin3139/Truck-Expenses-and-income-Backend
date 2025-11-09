package com.truckapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truckapp.model.Truck;

public interface TruckRepository extends JpaRepository<Truck, String> {
}
