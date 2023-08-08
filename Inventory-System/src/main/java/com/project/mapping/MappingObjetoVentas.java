package com.project.mapping;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ResponseDtoVentas;
import com.project.model.*;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

@Service
public class MappingObjetoVentas {

    public Ventas transformDtotoModel(ReqDtoVentas reqDtoVentas, Usuario usuario, Sucursal sucursal) throws Exception{
        Ventas ventasLocales;
        try{
            ventasLocales = new Ventas();
            ventasLocales.setUsuario(usuario);
            ventasLocales.setSucursal(sucursal);
            ventasLocales.setFechaVenta(reqDtoVentas.getFechaVentaDto());

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return ventasLocales;
    }

    public ResponseDtoVentas transformModeltoResponse(Ventas ventas) throws Exception{
        ResponseDtoVentas responseDtoVentasLocal;
        try{
            responseDtoVentasLocal = new ResponseDtoVentas();
            responseDtoVentasLocal.setFechaDto(ventas.getFechaVenta());
            responseDtoVentasLocal.setCantidadVendidoDto(ventas.getCantidadVendidos());
            responseDtoVentasLocal.setNombreVendedorDto(ventas.getUsuario().getNombreUsuario());
            responseDtoVentasLocal.setSucursalDto(ventas.getSucursal().getNombreSucursal());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoVentasLocal;
    }
}
