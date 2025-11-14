package com.truckapp.controller;

import com.truckapp.model.LedgerEntry;
import com.truckapp.repository.LedgerEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ledger")
public class LedgerController {
    @Autowired
    private LedgerEntryRepository repo;

    @GetMapping
    public List<LedgerEntry> getByPlaca(@RequestParam String placa) {
        return repo.findByPlaca(placa);
    }

    @PostMapping
    public LedgerEntry create(@RequestBody LedgerEntry entry) {
        return repo.save(entry);
    }

    @PutMapping("/{id}")
    public LedgerEntry update(@PathVariable Long id, @RequestBody LedgerEntry dto) {
        LedgerEntry e = repo.findById(id).orElse(new LedgerEntry());
        e.setType(dto.getType());
        e.setAmount(dto.getAmount());
        e.setDate(dto.getDate());
        e.setNote(dto.getNote());
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
