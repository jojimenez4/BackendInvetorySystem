package com.project.controller;

import com.project.dto.ReqDtoMarca;
import com.project.exception.NoEncontradoException;
import com.project.exception.NoGuardadoException;
import com.project.imp.MarcaImp;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    @Autowired
    private MarcaImp marcaImp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> agregarMarca(@RequestBody ReqDtoMarca reqDtoMarca){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(marcaImp.agregarMarca(reqDtoMarca), HttpStatus.OK);
        }catch(NoGuardadoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_GUARDAR, HttpStatus.NOT_ACCEPTABLE);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarMarca(@PathVariable  Long id){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(marcaImp.eliminarMarca(id), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ELIMINAR, HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> buscarPorIdMarca(@PathVariable  Long id){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(marcaImp.buscarPorId(id), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarMarca(){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(marcaImp.listarMarca(), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> modificarMarca(@PathVariable Long id, @RequestBody ReqDtoMarca reqDtoMarca){
        ResponseEntity<Object> rs = null;
        try{
            rs = new ResponseEntity<Object>(marcaImp.modificarMarca(id, reqDtoMarca), HttpStatus.OK);
        }catch(NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_ACTUALIZAR, HttpStatus.NOT_MODIFIED);
        }catch(Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
}
