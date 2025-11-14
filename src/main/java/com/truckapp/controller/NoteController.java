package com.truckapp.controller;

import com.truckapp.model.Note;
import com.truckapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteRepository repo;

    @GetMapping
    public List<Note> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return repo.save(note);
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note dto) {
        Note n = repo.findById(id).orElse(new Note());
        n.setTruck(dto.getTruck());
        n.setTitle(dto.getTitle());
        n.setText(dto.getText());
        n.setDate(dto.getDate());
        n.setDone(dto.getDone());
        return repo.save(n);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
