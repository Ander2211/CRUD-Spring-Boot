package com.empresa.controller;

import com.empresa.model.Cargo;
import com.empresa.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<Cargo> listar() {
        return cargoService.listarCargos();
    }

    @PostMapping
    public Cargo guardar(@Valid @RequestBody Cargo cargo) {
        return cargoService.guardarCargo(cargo);
    }

    @PutMapping("/{id}")
    public Cargo actualizar(@PathVariable Integer id, @Valid @RequestBody Cargo cargo) {
        cargo.setIdCargo(id);
        return cargoService.guardarCargo(cargo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cargoService.eliminarCargo(id);
    }
}
