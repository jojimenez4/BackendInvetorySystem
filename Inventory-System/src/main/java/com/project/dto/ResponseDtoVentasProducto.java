package com.project.dto;

import java.util.Date;

public class ResponseDtoVentasProducto {

    private String nombreVendedorDto;
    private Date fechaDto;
    private String productoDto;
    private int cantidadVendidoDto;
    private String sucursalDto;

    public String getNombreVendedorDto() {
        return nombreVendedorDto;
    }

    public void setNombreVendedorDto(String nombreVendedorDto) {
        this.nombreVendedorDto = nombreVendedorDto;
    }

    public Date getFechaDto() {
        return fechaDto;
    }

    public void setFechaDto(Date fechaDto) {
        this.fechaDto = fechaDto;
    }

    public String getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(String productoDto) {
        this.productoDto = productoDto;
    }

    public int getCantidadVendidoDto() {
        return cantidadVendidoDto;
    }

    public void setCantidadVendidoDto(int cantidadVendidoDto) {
        this.cantidadVendidoDto = cantidadVendidoDto;
    }

    public String getSucursalDto() {
        return sucursalDto;
    }

    public void setSucursalDto(String sucursalDto) {
        this.sucursalDto = sucursalDto;
    }
}
