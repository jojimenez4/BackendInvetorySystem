package com.project.imp;

import com.project.dto.ReqDtoVentas;
import com.project.dto.ReqDtoVP;
import com.project.dto.ResponseDtoVentas;
import com.project.dto.ResponseDtoVentasProducto;
import com.project.exception.NoEncontradoException;
import com.project.mapping.MappingObjetoVentas;
import com.project.mapping.MappingObjetoVentasProducto;
import com.project.model.*;
import com.project.repository.*;
import com.project.service.IVentasService;
import com.project.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentasImp implements IVentasService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private VentasProductoRepository ventasProductoRepository;

    @Autowired
    private MappingObjetoVentasProducto ma;

    @Override
    public ResponseDtoVentasProducto venderProductos(ReqDtoVentas reqDtoVentas) throws Exception {
        ResponseDtoVentasProducto dtoVentasProducto = null;
        Ventas ventasLocal = null;
        VentasProducto ventasProductoLocal = null;

        try{
            Usuario validarUsuario = usuarioRepository.findByUserName(reqDtoVentas.getVendedorDto());
            Sucursal sucursal = sucursalRepository.findByNombreSucursal(reqDtoVentas.getNombreSucursalDto());
            Producto producto = productoRepository.findByModelo(reqDtoVentas.getModeloDto());
            if(validarUsuario != null && sucursal != null && producto != null){
                ventasLocal = new Ventas();
                ventasLocal.setUsuario(validarUsuario);
                ventasLocal.setSucursal(sucursal);
                ventasLocal.setFechaVenta(reqDtoVentas.getFechaVentaDto());
                ventasLocal.setCantidadVendidos(reqDtoVentas.getCantidadVendidosDto());


                ventasProductoLocal = ventasProductoRepository.save(ma.transformarAVentasProducto(ventasLocal, producto));

                dtoVentasProducto = ma.transformModelToResponse(ventasProductoLocal);

            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return dtoVentasProducto;
    }

    @Override
    public List<ResponseDtoVentasProducto> listarVentas() throws Exception {
        List<ResponseDtoVentasProducto> listVentas = new ArrayList<>();
        try {
            List<VentasProducto> ventasProductos = ventasProductoRepository.findAll();
            for (VentasProducto vp : ventasProductos){
                listVentas.add(ma.transformModelToResponse(vp));
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        return listVentas;
    }
}