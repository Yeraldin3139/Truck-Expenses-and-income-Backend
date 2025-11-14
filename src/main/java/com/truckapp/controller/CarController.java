package com.truckapp.controller;

import com.truckapp.model.Car;
import com.truckapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarRepository repo;

    @GetMapping
    public List<Car> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return repo.save(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
