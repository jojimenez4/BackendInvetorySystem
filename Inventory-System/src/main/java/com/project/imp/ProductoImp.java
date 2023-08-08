package com.project.imp;

import com.project.dto.ReqDtoProducto;
import com.project.dto.ResponseDtoProducto;
import com.project.exception.NoActualizarException;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoProducto;
import com.project.model.Marca;
import com.project.model.Producto;
import com.project.repository.MarcaRepository;
import com.project.repository.ProductoRepository;
import com.project.service.IProductoService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoImp implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MappingObjetoProducto transformarObjetos;

    /**
     * Crear y guardar un objeto producto en la base de datos
     * @param reqDtoProducto
     * @return responseDtoProducto
     * @throws Exception
     */
    @Override
    public ResponseDtoProducto agregarProducto(ReqDtoProducto reqDtoProducto) throws Exception{
        ResponseDtoProducto responseDtoProducto = null;
        Producto productoLocal;

        try{
            Marca validarMarca = marcaRepository.findByNombreMarca(reqDtoProducto.getMarcaDto());
            if (validarMarca != null){
                productoLocal = new Producto();
                productoLocal.setCantidad(reqDtoProducto.getCantidadDto());
                productoLocal.setFechaProducto(reqDtoProducto.getFechaProductoDto());
                productoLocal.setMarca(validarMarca);
                productoLocal.setModelo(reqDtoProducto.getModeloDto());
                productoLocal.setPrecioCompra(reqDtoProducto.getPrecioCompraDto());
                productoLocal.setPrecioVenta(reqDtoProducto.getPrecioVentaDto());
                productoLocal.setSistemaOperativo(reqDtoProducto.getSistemaOperativoDto());
                responseDtoProducto = transformarObjetos.transformarProductoResponseDto(productoRepository.save(productoLocal));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoProducto;
    }

    /**
     * Metodo en el cual se modifica un objeto buscado por id
     * @param id
     * @param reqDtoProducto
     * @return
     * @throws Exception
     */
    @Override
    public ResponseDtoProducto modificarProducto(Long id, ReqDtoProducto reqDtoProducto) throws Exception {
        ResponseDtoProducto responseDtoProducto= null;
        try{

            Producto producto = productoRepository.findById(id).get();
            if(null != reqDtoProducto){

                producto.setCantidad(reqDtoProducto.getCantidadDto());
                producto.setPrecioVenta(reqDtoProducto.getPrecioVentaDto());
                Producto productoActualizado = productoRepository.save(producto);
                responseDtoProducto = transformarObjetos.transformarProductoResponseDto(productoActualizado);
                responseDtoProducto = transformarObjetos.transformarProductoResponseDto(productoRepository.saveAndFlush(producto));

            }else{
                throw new NoActualizarException(Constant.ERROR_ACTUALIZAR);
            }
        }catch(Exception ex){

            ex.printStackTrace();
        }
        return responseDtoProducto;
    }

    /**
     * Metodo en el cual se busca un objeto por id
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ResponseDtoProducto buscarPorId(Long id) throws Exception {
        ResponseDtoProducto dtoProducto;
        Producto productoLocal;
        try{
            productoLocal = transformarObjetos.transformarOptionaProducto(productoRepository.findById(id));
            if(null == productoLocal){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else {
                return transformarObjetos.transformarProductoResponseDto(productoLocal);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
    }

    /**
     * Metodo en el que se elimina un objeto de la base de datos por una id
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean eliminarProducto(Long id) throws Exception {
        try{
           Producto producto = transformarObjetos.transformarOptionaProducto(productoRepository.findById(id));
            if(null == producto){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }else{
                productoRepository.deleteById(id);
                return true;
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
    }

    /**
     * Metodo el cual trae los objetos de la base de datos
     * @return
     * @throws Exception
     */
    @Override
    public List<ResponseDtoProducto> listarProducto() throws Exception {
        List<ResponseDtoProducto> listProducto = new ArrayList<>();
        try {
            List<Producto> productos = productoRepository.findAll();
            for(Producto p : productos){
                listProducto.add(transformarObjetos.transformarProductoResponseDto( p ));
            }

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return listProducto;
    }
}
