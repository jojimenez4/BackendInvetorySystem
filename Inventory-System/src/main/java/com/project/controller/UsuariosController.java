package com.project.controller;

import com.project.dto.ReqDtoUsuario;
import com.project.dto.ReqDtoUsuarioLogin;
import com.project.exception.NoGuardadoException;
import com.project.exception.NoValidarSesionException;
import com.project.imp.UsuarioImp;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioImp usuarioImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> registrarUsuario(@RequestBody ReqDtoUsuario reqDtoUsuario){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.registrarUsuario(reqDtoUsuario), HttpStatus.OK);
        }catch (NoGuardadoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_GUARDAR, HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public ResponseEntity<Object> validarSesion(@RequestBody ReqDtoUsuarioLogin reqDtoUsuario){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.validarSesion(reqDtoUsuario), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_VALIDAR, HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPorIdUsuario(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.buscarPorId(id), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarUsuario(){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.listarUsuario(), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> modificarUsuario(@PathVariable Long id, @RequestBody ReqDtoUsuario reqDtoUsuario){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.modificarUsuario(id, reqDtoUsuario), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ACTUALIZAR, HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(usuarioImp.eliminarUsuario(id), HttpStatus.OK);
        }catch (NoValidarSesionException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ELIMINAR, HttpStatus.UNAUTHORIZED);
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
}
