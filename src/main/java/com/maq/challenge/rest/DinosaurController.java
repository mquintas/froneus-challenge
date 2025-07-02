package com.maq.challenge.rest;

import com.maq.challenge.domain.Dinosaur;
import com.maq.challenge.service.DinosaurService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/dinosaur")
public class DinosaurController {

    private final DinosaurService service;

    @Autowired
    public DinosaurController(DinosaurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Dinosaur> create(@Valid @RequestBody Dinosaur dinosaur) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dinosaur));
    }

    @GetMapping
    public ResponseEntity<List<Dinosaur>> findAll() {
        List<Dinosaur> dinosaurs = service.findAll();
        return ResponseEntity.ok(dinosaurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dinosaur> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dinosaur> update(@PathVariable Long id, @RequestBody Dinosaur dinosaur) {
        return ResponseEntity.ok(service.update(id, dinosaur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}