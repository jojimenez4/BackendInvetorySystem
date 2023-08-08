package com.project.dto;

import java.util.Date;

public class ReqDtoUsuario {
    private String cargoDto;
    private Date fechaDto;
    private String passwordDto;
    private String userNameDto;
    private String nombreDto;

    public String getNombreDto() {
        return nombreDto;
    }

    public void setNombreDto(String nombreDto) {
        this.nombreDto = nombreDto;
    }

    public String getUserNameDto() {
        return userNameDto;
    }

    public void setUserNameDto(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    public Date getFechaDto() {
        return fechaDto;
    }

    public void setFechaDto(Date fechaDto) {
        this.fechaDto = fechaDto;
    }

    public String getCargoDto() {
        return cargoDto;
    }

    public void setCargoDto(String cargoDto) {
        this.cargoDto = cargoDto;
    }
}
