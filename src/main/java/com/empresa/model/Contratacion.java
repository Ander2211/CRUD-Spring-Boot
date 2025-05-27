package com.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Contrataciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contratacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContratacion;
    
    @ManyToOne
    @JoinColumn(name = "idDepartamento", nullable = false)
    private Departamento departamento;
    
    @ManyToOne
    @JoinColumn(name = "idEmpleado", nullable = false)
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "idCargo", nullable = false)
    private Cargo cargo;
    
    @ManyToOne
    @JoinColumn(name = "idTipoContratacion", nullable = false)
    private TipoContratacion tipoContratacion;
    
    @Column(nullable = false)
    private LocalDate fechaContratacion;
    
    @Column(nullable = false)
    private BigDecimal salario;
    
    private Boolean estado = true;
}
