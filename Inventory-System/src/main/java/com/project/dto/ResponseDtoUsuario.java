package com.project.dto;

import java.util.Date;

public class ResponseDtoUsuario {
    private String nombreUsuarioDto;
    private String userNameDto;
    private Date fechaUsuarioDto;
    private String tipoRolDto;

    public String getNombreUsuarioDto() {
        return nombreUsuarioDto;
    }

    public void setNombreUsuarioDto(String nombreUsuarioDto) {
        this.nombreUsuarioDto = nombreUsuarioDto;
    }

    public String getUserNameDto() {
        return userNameDto;
    }

    public void setUserNameDto(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public Date getFechaUsuarioDto() {
        return fechaUsuarioDto;
    }

    public void setFechaUsuarioDto(Date fechaUsuarioDto) {
        this.fechaUsuarioDto = fechaUsuarioDto;
    }

    public String getTipoRolDto() {
        return tipoRolDto;
    }

    public void setTipoRolDto(String tipoRolDto) {
        this.tipoRolDto = tipoRolDto;
    }
}
