package com.project.service;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.dto.ResponseDtoVentas;
import com.project.dto.ResponseDtoVentasProducto;
import com.project.model.Ventas;

import java.util.Date;
import java.util.List;

public interface IVentasService {
    ResponseDtoVentasProducto venderProductos(ReqDtoVentas reqDtoVentas) throws Exception;
    List<ResponseDtoVentasProducto> listarVentas() throws Exception;
}
