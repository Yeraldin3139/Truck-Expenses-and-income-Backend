package com.truckapp.controller;

import com.truckapp.model.RoutePoint;
import com.truckapp.repository.RoutePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
    @Autowired
    private RoutePointRepository repo;

    @GetMapping
    public List<RoutePoint> get(@RequestParam String placa, @RequestParam String type) {
        return repo.findByPlacaAndTypeOrderByOrderAsc(placa, type);
    }

    @PostMapping
    public RoutePoint add(@RequestBody RoutePoint point) {        
        return repo.save(point);
    }

    @PostMapping("/batch")
    @Transactional
    public List<RoutePoint> saveBatch(@RequestBody List<RoutePoint> points) {                
        return repo.saveAll(points);
    }

    @PutMapping("/{id}")
    public RoutePoint update(@PathVariable Long id, @RequestBody RoutePoint dto) {
        RoutePoint r = repo.findById(id).orElse(new RoutePoint());
        r.setPlaca(dto.getPlaca());
        r.setType(dto.getType());
        r.setLat(dto.getLat());
        r.setLng(dto.getLng());
        r.setNombre(dto.getNombre());
        r.setEntregado(dto.getEntregado());
        r.setCarga(dto.getCarga());
        r.setDestino(dto.getDestino());
        r.setOrder(dto.getOrder());
        return repo.save(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping
    @Transactional
    public void deleteByPlacaAndType(@RequestParam String placa, @RequestParam String type) {
        repo.deleteByPlacaAndType(placa, type);
    }
}
