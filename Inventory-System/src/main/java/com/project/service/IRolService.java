package com.project.service;

import com.project.dto.ReqDtoRol;
import com.project.dto.ResponseDtoRol;
import com.project.model.Rol;

import java.util.List;

public interface IRolService {
    ResponseDtoRol añadirRol(ReqDtoRol reqDtoRol) throws  Exception;
    ResponseDtoRol modificarRol(Long id, ReqDtoRol reqDtoRol) throws Exception;
    Rol buscarPorId(Long id) throws Exception;
    boolean eliminarRol(Long id) throws Exception;
    List<ResponseDtoRol> listarRol() throws Exception;
}
