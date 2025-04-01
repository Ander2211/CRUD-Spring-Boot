package com.empresa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")  // Asegurar que coincide con la BD
    private Integer idEmpleado;

    @Column(name = "numer0Du1")
    private String numeroDui;

    @Column(name = "nombrePersona")
    private String nombrePersona;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "numericTelefono")
    private String numericTelefono;

    @Column(name = "correctInstitutional")
    private String correctInstitutional;

    @Column(name = "fechAlacimiento")
    private Date fechAlacimiento;

    @Column(nullable = false)
    private String cargo;

    // Getters y Setters
}
