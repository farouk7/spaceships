package com.example.springboot.controller;

import com.example.springboot.model.SpaceShip;
import com.example.springboot.service.SpaceShipService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaceships")
public class SpaceShipController {
    private final SpaceShipService service;

    public SpaceShipController(SpaceShipService service) {
        this.service = service;
    }

    @GetMapping
    public Page<SpaceShip> getAllShips(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public SpaceShip getShipById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public Page<SpaceShip> searchShips(@RequestParam String name, Pageable pageable) {
        return service.findByName(name, pageable);
    }

    @PostMapping
    public SpaceShip createShip(@RequestBody SpaceShip spaceship) {
        return service.save(spaceship);
    }

    @PutMapping("/{id}")
    public SpaceShip updateShip(@PathVariable Long id, @RequestBody SpaceShip spaceship) {
        spaceship.setId(id);
        return service.update(spaceship);
    }

    @DeleteMapping("/{id}")
    public void deleteShip(@PathVariable Long id) {
        service.delete(id);
    }
}
