package com.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "sistema_operativo", nullable = false)
    private String sistemaOperativo;

    @Column(name = "precio_compra", nullable = false)
    private int precioCompra;

    @Column(name = "precio_venta", nullable = false)
    private int precioVenta;

    @Column(name = "fecha", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd")
    private Date fechaProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marca marca;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<VentasProducto> productoL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<ProductoSucursal> productoSucursal;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precio) {
        this.precioCompra = precio;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(Date fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<VentasProducto> getProductoL() {
        return productoL;
    }

    public void setProductoL(List<VentasProducto> productoL) {
        this.productoL = productoL;
    }

    public List<ProductoSucursal> getProductoSucursal() {
        return productoSucursal;
    }

    public void setProductoSucursal(List<ProductoSucursal> productoSucursal) {
        this.productoSucursal = productoSucursal;
    }
}
