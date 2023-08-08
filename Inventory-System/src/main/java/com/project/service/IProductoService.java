package com.project.service;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;
import com.project.model.Producto;

import java.util.List;

public interface IProductoService {
    ResponseDtoProducto agregarProducto(ReqDtoProducto reqDtoProducto) throws Exception;
    ResponseDtoProducto buscarPorId(Long id) throws Exception;
    ResponseDtoProducto modificarProducto(Long id, ReqDtoProducto reqDtoProducto) throws Exception;
    boolean eliminarProducto(Long id) throws Exception;
    List<ResponseDtoProducto> listarProducto() throws Exception;
}
