package com.truckapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truckapp.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
