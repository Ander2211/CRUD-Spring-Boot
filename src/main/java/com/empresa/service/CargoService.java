package com.empresa.service;

import com.empresa.model.Cargo;
import com.empresa.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }

    public Cargo guardarCargo(Cargo cargo) {
        if (cargo.getCargo() == null || cargo.getCargo().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cargo no puede estar vacío");
        }

        // Asegurarse de que el ID sea null para nuevos registros
        if (cargo.getIdCargo() != null && cargo.getIdCargo() == 0) {
            cargo.setIdCargo(null);
        }

        try {
            return cargoRepository.save(cargo);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al guardar el cargo: " + e.getMessage());
        }
    }

    public void eliminarCargo(Integer id) {
        try {
            cargoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("El cargo con ID " + id + " no existe");
        }
    }
}
