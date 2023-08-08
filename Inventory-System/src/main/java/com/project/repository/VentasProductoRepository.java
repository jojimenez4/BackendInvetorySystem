package com.project.repository;

import com.project.model.VentasProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasProductoRepository extends JpaRepository<VentasProducto, Long> {
}
