package com.project.dto;

import java.util.Date;

public class ReqDtoVentas {
    private String vendedorDto;
    private String nombreSucursalDto;
    private Date fechaVentaDto;
    private int cantidadVendidosDto;
    private String modeloDto;

    public String getVendedorDto() {
        return vendedorDto;
    }

    public void setVendedorDto(String vendedorDto) {
        this.vendedorDto = vendedorDto;
    }

    public String getNombreSucursalDto() {
        return nombreSucursalDto;
    }

    public void setNombreSucursalDto(String nombreSucursalDto) {
        this.nombreSucursalDto = nombreSucursalDto;
    }

    public Date getFechaVentaDto() {
        return fechaVentaDto;
    }

    public void setFechaVentaDto(Date fechaVentaDto) {
        this.fechaVentaDto = fechaVentaDto;
    }

    public int getCantidadVendidosDto() {
        return cantidadVendidosDto;
    }

    public void setCantidadVendidosDto(int cantidadVendidosDto) {
        this.cantidadVendidosDto = cantidadVendidosDto;
    }

    public String getModeloDto() {
        return modeloDto;
    }

    public void setModeloDto(String modeloDto) {
        this.modeloDto = modeloDto;
    }
}
