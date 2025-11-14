package com.truckapp.controller;

import com.truckapp.model.Driver;
import com.truckapp.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    @Autowired
    private DriverRepository repo;

    @PostMapping("/login")
    public Driver login(@RequestBody Driver dto) {
        Optional<Driver> existing = repo.findByNombreAndPlaca(dto.getNombre(), dto.getPlaca());
        if (existing.isPresent()) return existing.get();
        Driver d = new Driver();
        d.setNombre(dto.getNombre());
        d.setPlaca(dto.getPlaca());
        d.setTelefono(dto.getTelefono());
        return repo.save(d);
    }

    @GetMapping
    public List<Driver> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Driver get(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Driver update(@PathVariable Long id, @RequestBody Driver dto) {
        Driver d = repo.findById(id).orElse(new Driver());
        d.setNombre(dto.getNombre());
        d.setTelefono(dto.getTelefono());
        d.setCedula(dto.getCedula());
        d.setRuta(dto.getRuta());
        return repo.save(d);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
