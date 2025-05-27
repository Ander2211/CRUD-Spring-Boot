package com.example.crud.controller;

import com.example.crud.model.Cargo;
import com.example.crud.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "http://localhost:3000") // Ajustar según el puerto del frontend
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    @PostMapping
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
