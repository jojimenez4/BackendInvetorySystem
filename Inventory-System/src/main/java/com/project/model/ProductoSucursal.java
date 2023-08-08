package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "producto_has_sucursal")
public class ProductoSucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productosucursal")
    private Long idProductoSucursal;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false, updatable = false)
    private Producto producto;

    public Long getIdProductoSucursal() {
        return idProductoSucursal;
    }

    public void setIdProductoSucursal(Long idProductoSucursal) {
        this.idProductoSucursal = idProductoSucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
