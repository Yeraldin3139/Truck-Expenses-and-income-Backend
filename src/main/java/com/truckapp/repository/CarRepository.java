package com.truckapp.repository;

import com.truckapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByPlaca(String placa);
}
