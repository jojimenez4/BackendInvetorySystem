package com.project.mapping;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ResponseDtoUsuario;
import com.project.dto.ResponseDtoUsuarioLogin;
import com.project.model.Rol;
import com.project.model.Usuario;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoUsuarios {

    public Usuario transformarDtoAUsuario(ReqDtoUsuario reqDtoUsuario, Rol rol) throws Exception {
        Usuario usuarioLocal = null;
        try{
            usuarioLocal = new Usuario();
            usuarioLocal.setNombreUsuario(reqDtoUsuario.getNombreDto());
            usuarioLocal.setUserName(reqDtoUsuario.getUserNameDto());
            usuarioLocal.setPasswordUsuario(reqDtoUsuario.getPasswordDto());
            usuarioLocal.setRol(rol);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
     return usuarioLocal;
    }

    public ResponseDtoUsuario transforUserToResponse(Usuario usuarioLocal) throws Exception {
        ResponseDtoUsuario usuarioDto = null;
        try{
            usuarioDto = new ResponseDtoUsuario();
            usuarioDto.setNombreUsuarioDto(usuarioLocal.getNombreUsuario());
            usuarioDto.setUserNameDto(usuarioLocal.getUserName());
            usuarioDto.setTipoRolDto(usuarioLocal.getRol().getCargo());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return usuarioDto;
    }

    public ResponseDtoUsuarioLogin transforModelToResponse(Usuario usuarioLocal) throws Exception {
        ResponseDtoUsuarioLogin usuarioDto = null;
        try{
            usuarioDto = new ResponseDtoUsuarioLogin();
            usuarioDto.setUserNameDto(usuarioLocal.getUserName());
            usuarioDto.setCargoDto(usuarioLocal.getRol().getCargo());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception();
        }
        return usuarioDto;
    }

    public Usuario transformarOptionalaUsuario(Optional<Usuario> usuarioOptional) throws Exception{
        Usuario usuarioLocal = null;
        try{
            if(usuarioOptional.isPresent()){
                usuarioLocal = new Usuario();
                usuarioLocal.setIdUsuario(usuarioOptional.get().getIdUsuario());
                usuarioLocal.setRol(usuarioOptional.get().getRol());
                usuarioLocal.setNombreUsuario(usuarioOptional.get().getNombreUsuario());
                usuarioLocal.setPasswordUsuario(usuarioOptional.get().getPasswordUsuario());
                usuarioLocal.setUserName(usuarioOptional.get().getUserName());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return usuarioLocal;
    }
}
