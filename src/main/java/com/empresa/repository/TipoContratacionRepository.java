package com.empresa.repository;

import com.empresa.model.TipoContratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContratacionRepository extends JpaRepository<TipoContratacion, Integer> {
}
