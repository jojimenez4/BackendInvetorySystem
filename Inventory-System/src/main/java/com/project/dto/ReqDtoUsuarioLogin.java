package com.project.dto;

import org.springframework.stereotype.Service;

@Service
public class ReqDtoUsuarioLogin {

    private String userNameDto;
    private String passwordDto;

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
}
