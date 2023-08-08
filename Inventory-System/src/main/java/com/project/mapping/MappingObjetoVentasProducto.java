package com.project.mapping;

import com.project.dto.ResponseDtoVentasProducto;
import com.project.model.Producto;
import com.project.model.Ventas;
import com.project.model.VentasProducto;
import org.springframework.stereotype.Service;

@Service
public class MappingObjetoVentasProducto {

    public VentasProducto transformarAVentasProducto(Ventas ventas, Producto producto) throws Exception{
        VentasProducto ventasProductoLocal;
        try {
            ventasProductoLocal = new VentasProducto();
            ventasProductoLocal.setVentas(ventas);
            ventasProductoLocal.setProducto(producto);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return ventasProductoLocal;
    }

    public ResponseDtoVentasProducto transformModelToResponse(VentasProducto ventasProducto) throws Exception{
        ResponseDtoVentasProducto dtoVentasProducto;
        try {
            dtoVentasProducto = new ResponseDtoVentasProducto();
            dtoVentasProducto.setNombreVendedorDto(ventasProducto.getVentas().getUsuario().getNombreUsuario());
            dtoVentasProducto.setSucursalDto(ventasProducto.getVentas().getSucursal().getNombreSucursal());
            dtoVentasProducto.setCantidadVendidoDto(ventasProducto.getVentas().getCantidadVendidos());
            dtoVentasProducto.setFechaDto(ventasProducto.getVentas().getFechaVenta());
            dtoVentasProducto.setProductoDto(ventasProducto.getProducto().getModelo());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return dtoVentasProducto;
    }
}
