import React, { useState, useEffect } from "react";
import Navbar from "./Navbar"; // Importar el componente Navbar

const Cargos = () => {
  const [cargos, setCargos] = useState([]);
  const [nombre, setNombre] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/cargos")
      .then((response) => response.json())
      .then((data) => setCargos(data));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/api/cargos", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nombre }),
    })
      .then((response) => response.json())
      .then((newCargo) => setCargos([...cargos, newCargo]));
    setNombre("");
  };

  return (
    <div>
      <Navbar /> {/* Incluir la navbar */}
      <h1>Cargos</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
          placeholder="Nombre del cargo"
          required
        />
        <button type="submit">Agregar Cargo</button>
      </form>
      <ul>
        {cargos.map((cargo) => (
          <li key={cargo.id}>{cargo.nombre}</li>
        ))}
      </ul>
    </div>
  );
};

export default Cargos;
