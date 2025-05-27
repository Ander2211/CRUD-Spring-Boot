package com.empresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @NotBlank(message = "El DUI es obligatorio")
    @Pattern(regexp = "^[0-9]{8}-[0-9]$", message = "El DUI debe tener el formato 12345678-9")
    @Column(name = "numeroDui", nullable = false)
    private String numeroDui;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombrePersona", nullable = false)
    private String nombrePersona;

    @NotBlank(message = "El usuario es obligatorio")
    @Column(name = "usuario", nullable = false)
    private String usuario;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{8}$", message = "El teléfono debe tener exactamente 8 dígitos")
    @Column(name = "numericTelefono", nullable = false)
    private String numericTelefono;

    @NotBlank(message = "El correo institucional es obligatorio")
    @Column(name = "correctInstitutional", nullable = false)
    private String correctInstitutional;

    @Column(name = "fechAlacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechAlacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCargo", nullable = false)
    private Cargo cargo;

    // Getters y Setters
}
