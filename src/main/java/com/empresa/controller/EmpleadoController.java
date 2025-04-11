package com.empresa.controller;

import com.empresa.model.Empleado;
import com.empresa.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<?> guardarEmpleado(@Valid @RequestBody Empleado empleado, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errores);
        }
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
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Integer id, @Valid @RequestBody Empleado empleado, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errores);
        }
        try {
            empleado.setIdEmpleado(id);
            Empleado actualizado = empleadoService.guardarEmpleado(empleado);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar empleado: " + e.getMessage());
        }
    }

}
