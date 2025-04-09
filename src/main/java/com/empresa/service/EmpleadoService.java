package com.empresa.service;


import com.empresa.model.Empleado;
import com.empresa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void eliminarEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}

