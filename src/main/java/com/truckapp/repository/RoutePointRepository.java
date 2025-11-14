package com.truckapp.repository;

import com.truckapp.model.RoutePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoutePointRepository extends JpaRepository<RoutePoint, Long> {
    List<RoutePoint> findByPlacaAndTypeOrderByOrderAsc(String placa, String type);
    void deleteByPlacaAndType(String placa, String type);
}
