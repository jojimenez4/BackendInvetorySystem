package com.project.dto;

public class ResponseDtoUsuarioLogin {

    private String userNameDto;
    private String cargoDto;

    public String getUserNameDto() {
        return userNameDto;
    }

    public void setUserNameDto(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public String getCargoDto() {
        return cargoDto;
    }

    public void setCargoDto(String cargoDto) {
        this.cargoDto = cargoDto;
    }
}
