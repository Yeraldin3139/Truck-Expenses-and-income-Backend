package com.truckapp.repository;

import com.truckapp.model.TripSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripSimpleRepository extends JpaRepository<TripSimple, Long> {
    List<TripSimple> findByPlaca(String placa);
}
