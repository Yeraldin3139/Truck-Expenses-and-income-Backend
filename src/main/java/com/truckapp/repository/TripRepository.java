package com.truckapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truckapp.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
