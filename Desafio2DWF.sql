-- primero esta el script de la base de datos

create database RecursosHumanos;
use recursoshumanos;

-- Crear tabla Empleados
CREATE TABLE Empleados (
    idEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    numeroDui VARCHAR(9) NOT NULL,
    nombrePersona VARCHAR(50) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    numericTelefono VARCHAR(9) NOT NULL,
    correctInstitutional VARCHAR(50) NOT NULL,
    fechAlacimiento DATE NOT NULL,
    idCargo INT NOT NULL,
    FOREIGN KEY (idCargo) REFERENCES Cargos(idCargo)
);

-- Crear tabla Departamento
CREATE TABLE Departamento (
    idDepartamento INT AUTO_INCREMENT PRIMARY KEY,
    nombreDepartamento VARCHAR(50) NOT NULL,
    descripcionDepartamento TEXT NOT NULL
);

-- Crear tabla TipoContratacion
CREATE TABLE TipoContratacion (
    idTipoContratacion INT AUTO_INCREMENT PRIMARY KEY,
    tipoContratacion VARCHAR(100) NOT NULL
);

-- Crear tabla Cargos
CREATE TABLE Cargos (
    idCargo INT PRIMARY KEY AUTO_INCREMENT,
    cargo VARCHAR(50) NOT NULL,
    descripcionCargo TEXT,
    belatura BOOLEAN NOT NULL DEFAULT TRUE
);

-- Crear tabla Contrataciones
CREATE TABLE Contrataciones (
    idContratacion INT AUTO_INCREMENT PRIMARY KEY,
    idDepartamento INT NOT NULL,
    idEmpleado INT NOT NULL,
    idCargo INT NOT NULL,
    idTipoContratacion INT NOT NULL,
    fechaContratacion DATE NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    estado BOOLEAN NOT NULL,
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado),
    FOREIGN KEY (idCargo) REFERENCES Cargos(idCargo),
    FOREIGN KEY (idTipoContratacion) REFERENCES TipoContratacion(idTipoContratacion)
);
