package com.project.repository;

import com.project.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Marca findByNombreMarca(String nombreMarca);
}
