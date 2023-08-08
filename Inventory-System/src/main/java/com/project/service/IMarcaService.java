package com.project.service;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
import com.project.model.Marca;

import java.util.List;

public interface IMarcaService {
    ResponseDtoMarca agregarMarca(ReqDtoMarca reqDtoMarca) throws Exception;
    boolean eliminarMarca(Long id) throws Exception;
    Marca buscarPorId(Long id) throws Exception;
    List<ResponseDtoMarca> listarMarca() throws Exception;
    ResponseDtoMarca modificarMarca(Long id, ReqDtoMarca reqDtoMarca) throws Exception;

}
