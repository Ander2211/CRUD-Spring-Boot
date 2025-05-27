package com.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TipoContratacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoContratacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoContratacion;
    
    @Column(nullable = false)
    private String tipoContratacion;
}
