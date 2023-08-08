package com.project.mapping;

import com.project.dto.ResponseDtoProducto;
import com.project.model.Producto;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoProducto {

    public ResponseDtoProducto transformarProductoResponseDto(Producto producto) throws Exception{
        ResponseDtoProducto responseDtoProducto = null;
       try{
           if (null != producto){
               responseDtoProducto = new ResponseDtoProducto();
               responseDtoProducto.setIdProductoDto(producto.getIdProducto());
               responseDtoProducto.setCantidadDto(producto.getCantidad());
               responseDtoProducto.setFechaProductoDto(producto.getFechaProducto());
               responseDtoProducto.setSistemaOperativoDto(producto.getSistemaOperativo());
               responseDtoProducto.setModeloDto(producto.getModelo());
               responseDtoProducto.setPrecioCompraDto(producto.getPrecioCompra());
               responseDtoProducto.setPrecioVentaDto(producto.getPrecioVenta());
               responseDtoProducto.setMarcaDto(producto.getMarca().getNombreMarca());
           }
       } catch (Exception ex){
           ex.printStackTrace();
           throw new Exception(Constant.ERROR_SISTEMA);
       }
       return responseDtoProducto;
    }

    public Producto transformarOptionaProducto(Optional<Producto> productoOptional) throws Exception {
       Producto producto = null;
        try {
            if(productoOptional.isPresent()){
                producto = new Producto();
                producto.setIdProducto(productoOptional.get().getIdProducto());
                producto.setMarca(productoOptional.get().getMarca());
                producto.setPrecioCompra(productoOptional.get().getPrecioCompra());
                producto.setPrecioVenta(productoOptional.get().getPrecioVenta());
                producto.setFechaProducto(productoOptional.get().getFechaProducto());
                producto.setModelo(productoOptional.get().getModelo());
                producto.setCantidad(productoOptional.get().getCantidad());
                producto.setSistemaOperativo(productoOptional.get().getSistemaOperativo());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return producto;
    }
}
