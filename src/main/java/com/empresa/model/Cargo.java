package com.empresa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargo")
    private Integer idCargo;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "descripcionCargo")
    private String descripcionCargo;

    // Getters y Setters
}
