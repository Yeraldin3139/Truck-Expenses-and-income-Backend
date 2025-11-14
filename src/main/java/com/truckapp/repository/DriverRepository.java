package com.truckapp.repository;

import com.truckapp.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByNombreAndPlaca(String nombre, String placa);
}
