package com.project.controller;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.exception.NoEncontradoException;
import com.project.imp.VentasImp;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {

    @Autowired
    private VentasImp ventasImp;

    @RequestMapping(value = "/vender", method = RequestMethod.POST)
    public ResponseEntity<Object> venderProducto(@RequestBody ReqDtoVentas reqDtoVentas){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.venderProductos(reqDtoVentas), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_GUARDAR, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Object> listarVentas(){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(ventasImp.listarVentas(), HttpStatus.OK);
        } catch (NoEncontradoException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_NO_ENCONTRADO, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(Constant.ERROR_SISTEMA, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
}
