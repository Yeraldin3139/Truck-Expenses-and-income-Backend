package com.truckapp.controller;

import com.truckapp.model.TripSimple;
import com.truckapp.model.TripTransaction;
import com.truckapp.repository.TripSimpleRepository;
import com.truckapp.repository.TripTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripSimpleController {
    @Autowired
    private TripSimpleRepository tripRepo;
    @Autowired
    private TripTransactionRepository txRepo;

    @GetMapping
    public List<TripSimple> getAll() {
        return tripRepo.findAll();
    }

    @PostMapping
    public TripSimple create(@RequestBody TripSimple trip) {
        return tripRepo.save(trip);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        txRepo.deleteByTripId(id);
        tripRepo.deleteById(id);
    }

    @GetMapping("/{id}/transactions")
    public List<TripTransaction> getTx(@PathVariable Long id) {
        return txRepo.findByTripId(id);
    }

    @PostMapping("/{id}/transactions")
    public TripTransaction createTx(@PathVariable Long id, @RequestBody TripTransaction tx) {
        tx.setTripId(id);
        return txRepo.save(tx);
    }

    @PutMapping("/transactions/{txId}")
    public TripTransaction updateTx(@PathVariable Long txId, @RequestBody TripTransaction dto) {
        TripTransaction t = txRepo.findById(txId).orElse(new TripTransaction());
        t.setType(dto.getType());
        t.setAmount(dto.getAmount());
        t.setDate(dto.getDate());
        t.setNote(dto.getNote());
        return txRepo.save(t);
    }

    @DeleteMapping("/transactions/{txId}")
    public void deleteTx(@PathVariable Long txId) {
        txRepo.deleteById(txId);
    }
}
