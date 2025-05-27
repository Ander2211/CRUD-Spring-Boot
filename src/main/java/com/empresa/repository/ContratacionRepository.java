package com.empresa.repository;

import com.empresa.model.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratacionRepository extends JpaRepository<Contratacion, Integer> {
}
