package com.example.springboot.service;

import com.example.springboot.model.SpaceShip;
import com.example.springboot.repository.SpaceShipRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SpaceShipService {
    private final SpaceShipRepository repository;

    public SpaceShipService(SpaceShipRepository repository) {
        this.repository = repository;
    }

    @Cacheable("spaceships")
    public Page<SpaceShip> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Cacheable("spaceship")
    public SpaceShip findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Nave no encontrada"));
    }

    @Cacheable("spaceships")
    public Page<SpaceShip> findByName(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }

    public SpaceShip save(SpaceShip spaceship) {
        return repository.save(spaceship);
    }

    public SpaceShip update(SpaceShip spaceship) {
        if (!repository.existsById(spaceship.getId())) {
            throw new EntityNotFoundException("Ship not found");
        }
        return repository.save(spaceship);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
