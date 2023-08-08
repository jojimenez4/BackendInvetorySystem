package com.project.service;

import com.project.dto.ReqDtoSucursal;
import com.project.dto.ResponseDtoMarca;
import com.project.dto.ResponseDtoSucursal;
import com.project.model.Sucursal;

import java.util.List;

public interface ISucursalService {

    ResponseDtoSucursal agregarSucursal(ReqDtoSucursal reqDtoSucursal) throws Exception;
    boolean eliminarSucursal(Long id) throws Exception;
    Sucursal buscarPorId(Long id) throws Exception;
    List<ResponseDtoSucursal> listarSucursal() throws Exception;
    ResponseDtoSucursal modificarSucursal(Long id, ReqDtoSucursal reqDtoSucursal) throws Exception;
}
