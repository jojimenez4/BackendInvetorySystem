package com.project.controller;

import com.project.dto.ReqDtoRol;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.imp.RolImp;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolImp rolImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> agregarRol(@RequestBody ReqDtoRol reqDtoRol) {
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(rolImp.añadirRol(reqDtoRol), HttpStatus.OK);
        } catch (NoGuardadoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_GUARDAR, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPorIdRol(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(rolImp.buscarPorId(id), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> modificarRol(@PathVariable  Long id, @RequestBody ReqDtoRol reqDtoRol){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(rolImp.modificarRol(id, reqDtoRol), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ACTUALIZAR, HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarRol(@PathVariable  Long id){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(rolImp.eliminarRol(id), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ELIMINAR, HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarRol(){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(rolImp.listarRol(), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
