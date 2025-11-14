package com.truckapp.controller;

import com.truckapp.model.Schedule;
import com.truckapp.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleRepository repo;

    @GetMapping
    public List<Schedule> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{placa}")
    public Schedule get(@PathVariable String placa) {
        return repo.findById(placa).orElse(null);
    }

    @PostMapping
    public Schedule save(@RequestBody Schedule schedule) {
        return repo.save(schedule);
    }
}
