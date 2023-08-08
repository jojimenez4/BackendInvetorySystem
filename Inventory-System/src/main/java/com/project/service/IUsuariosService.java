package com.project.service;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ReqDtoUsuarioLogin;
import com.project.dto.ResponseDtoUsuario;
import com.project.model.Usuario;

import java.util.List;

public interface IUsuariosService {

    ResponseDtoUsuario registrarUsuario(ReqDtoUsuario reqDtoUsuario) throws Exception;
    ResponseDtoUsuario validarSesion(ReqDtoUsuarioLogin reqDtoUsuario) throws Exception;
    Usuario buscarPorId(Long id) throws Exception;
    ResponseDtoUsuario modificarUsuario(Long id, ReqDtoUsuario reqDtoUsuario) throws Exception;
    boolean eliminarUsuario(Long id) throws Exception;
    List<ResponseDtoUsuario> listarUsuario() throws Exception;
}
