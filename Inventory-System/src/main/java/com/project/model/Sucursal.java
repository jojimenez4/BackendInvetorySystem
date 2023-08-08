package com.project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long idSucursal;

    @Column(name = "nombre_sucursal", nullable = false, unique = true)
    private String nombreSucursal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursal")
    private List<ProductoSucursal> sucursalProducto;

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public List<ProductoSucursal> getSucursalProducto() {
        return sucursalProducto;
    }

    public void setSucursalProducto(List<ProductoSucursal> sucursalProducto) {
        this.sucursalProducto = sucursalProducto;
    }
}


