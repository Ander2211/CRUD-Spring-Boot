import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ padding: "10px", backgroundColor: "#f0f0f0" }}>
      <ul style={{ listStyle: "none", display: "flex", gap: "10px" }}>
        <li>
          <Link to="/">Inicio</Link>
        </li>
        <li>
          <Link to="/cargos">Cargos</Link>
        </li>
        {/* Agregar más enlaces según sea necesario */}
      </ul>
    </nav>
  );
};

export default Navbar;
