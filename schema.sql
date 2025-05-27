-- despues de crear la base de datos, se actualiza la tabla Empleados

-- Actualizar la tabla Empleados
ALTER TABLE Empleados
    CHANGE COLUMN numer0Du1 numeroDui VARCHAR(9) NOT NULL,
    ADD COLUMN idCargo INT NOT NULL AFTER fechAlacimiento,
    ADD CONSTRAINT fk_empleado_cargo FOREIGN KEY (idCargo) REFERENCES Cargos(idCargo);

-- Actualizar la tabla Departamento
ALTER TABLE Departamento
    CHANGE COLUMN numberDepartamento nombreDepartamento VARCHAR(50) NOT NULL;

-- Actualizar la tabla TipoContratacion
ALTER TABLE TipoContratacion
    CHANGE COLUMN idTipContratacion idTipoContratacion INT AUTO_INCREMENT PRIMARY KEY;

-- Actualizar la tabla Contrataciones
ALTER TABLE Contrataciones
    CHANGE COLUMN fechAContratacion fechaContratacion DATE NOT NULL,
    CHANGE COLUMN idTipContratacion idTipoContratacion INT NOT NULL,
    DROP FOREIGN KEY contrataciones_ibfk_4,
    ADD CONSTRAINT fk_contratacion_tipo FOREIGN KEY (idTipoContratacion) REFERENCES TipoContratacion(idTipoContratacion); 