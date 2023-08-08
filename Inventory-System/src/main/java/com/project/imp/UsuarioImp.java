package com.project.imp;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ReqDtoUsuarioLogin;
import com.project.dto.ResponseDtoUsuario;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.exception.NoValidarSesionException;
import com.project.mapping.MappingObjetoUsuarios;
import com.project.model.Rol;
import com.project.model.Usuario;
import com.project.repository.RolRepository;
import com.project.repository.UsuarioRepository;
import com.project.service.IPbkdf2EncryptService;
import com.project.service.IUsuariosService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioImp implements IUsuariosService {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private IPbkdf2EncryptService iPbkdf2EncryptService;

    @Autowired
    private MappingObjetoUsuarios mappingObjetoUsuarios;

    @Override
    public ResponseDtoUsuario registrarUsuario(ReqDtoUsuario reqDtoUsuario) throws Exception {
        ResponseDtoUsuario responseDtoUsuario;
        Usuario usuario;
        try {
            Rol validarRol = rolRepository.findByCargo(reqDtoUsuario.getCargoDto());
            Usuario validarUserName = usuariosRepository.findByUserName(reqDtoUsuario.getUserNameDto());
            if (validarUserName == null && validarRol != null) {
                usuario = new Usuario();
                usuario.setNombreUsuario(reqDtoUsuario.getNombreDto());
                usuario.setUserName(reqDtoUsuario.getUserNameDto());
                usuario.setRol(validarRol);
                usuario.setPasswordUsuario(iPbkdf2EncryptService.generarHashPassword(reqDtoUsuario.getPasswordDto()));

                responseDtoUsuario = mappingObjetoUsuarios.transforUserToResponse(usuariosRepository.save(usuario));
            } else {
                throw new NoGuardadoException(Constant.ERROR_GUARDAR);
            }
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            throw new NoGuardadoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return responseDtoUsuario;
    }

    @Override
    public ResponseDtoUsuario validarSesion(ReqDtoUsuarioLogin reqDtoUsuario) throws Exception {
        Usuario usuarioLocal;
        try {
            usuarioLocal = usuariosRepository.findByUserName(reqDtoUsuario.getUserNameDto());
            Usuario u = usuariosRepository.findByUserName(reqDtoUsuario.getUserNameDto());
            Rol validarRol = rolRepository.findByCargo(u.getRol().getCargo());
            if (usuarioLocal != null && validarRol != null){

                if(iPbkdf2EncryptService.validarPassword(reqDtoUsuario.getPasswordDto(), usuarioLocal.getPasswordUsuario()))
                {
                    MappingObjetoUsuarios m = new MappingObjetoUsuarios();
                    return m.transforUserToResponse(usuarioLocal);
                }else{
                    throw new NoValidarSesionException(Constant.ERROR_VALIDAR);
                }
            }else {
                throw new NoValidarSesionException(Constant.ERROR_VALIDAR);
            }
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            throw new NoValidarSesionException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Usuario buscarPorId(Long id) throws Exception {
        Usuario usuarioLocal;
        try{
            usuarioLocal = mappingObjetoUsuarios.transformarOptionalaUsuario(usuariosRepository.findById(id));
            if(usuarioLocal == null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch(NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return usuarioLocal;
    }

    @Override
    public ResponseDtoUsuario modificarUsuario(Long id, ReqDtoUsuario reqDtoUsuario) throws Exception {
        ResponseDtoUsuario responseDtoUsuario = null;
        try{
            Usuario usuario = usuariosRepository.findById(id).get();
            if (reqDtoUsuario != null){
                usuario.setUserName(reqDtoUsuario.getUserNameDto());
                usuario.setPasswordUsuario(reqDtoUsuario.getPasswordDto());
                Usuario usuarioActualizado = usuariosRepository.save(usuario);
                responseDtoUsuario = mappingObjetoUsuarios.transforUserToResponse(usuarioActualizado);
                responseDtoUsuario = mappingObjetoUsuarios.transforUserToResponse(usuariosRepository.saveAndFlush(usuario));
            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return responseDtoUsuario;
    }

    @Override
    public boolean eliminarUsuario(Long id) throws Exception {
        try{
            Usuario usuario = mappingObjetoUsuarios.transformarOptionalaUsuario(usuariosRepository.findById(id));
            if(usuario == null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                usuariosRepository.deleteById(id);
                return true;
            }

        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<ResponseDtoUsuario> listarUsuario() throws Exception {
        List<ResponseDtoUsuario> listUsuario = new ArrayList<>();
        try{
            List<Usuario> usuarios = usuariosRepository.findAll();
            for(Usuario u : usuarios){
                listUsuario.add(mappingObjetoUsuarios.transforUserToResponse(u));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return listUsuario;
    }

}