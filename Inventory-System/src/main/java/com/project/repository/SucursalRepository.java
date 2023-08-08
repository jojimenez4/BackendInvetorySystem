package com.project.repository;

import com.project.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    Sucursal findByNombreSucursal(String nombreSucursal);

}
