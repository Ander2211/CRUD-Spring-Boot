package com.empresa.service;


import com.empresa.model.Empleado;
import com.empresa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> listarTodos() {
        return repository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado);
    }

    public Empleado obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

