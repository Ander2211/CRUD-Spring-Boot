package com.empresa.controller;


import com.empresa.model.Empleado;
import com.empresa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Permitir llamadas desde el frontend
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @PostMapping
    public ResponseEntity<?> guardarEmpleado(@RequestBody Empleado empleado) {
        try {
            Empleado nuevoEmpleado = empleadoService.guardarEmpleado(empleado);
            return ResponseEntity.ok(nuevoEmpleado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar empleado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer id) {
        try {
            empleadoService.eliminarEmpleado(id);
            return ResponseEntity.ok("Empleado eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar empleado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        try {
            empleado.setIdEmpleado(id); // Asegura que el ID se mantenga correcto
            Empleado actualizado = empleadoService.guardarEmpleado(empleado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar empleado: " + e.getMessage());
        }
    }

}