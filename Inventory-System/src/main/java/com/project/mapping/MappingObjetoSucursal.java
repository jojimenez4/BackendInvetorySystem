package com.project.mapping;

import com.project.dto.ResponseDtoSucursal;
import com.project.model.Sucursal;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoSucursal {

    public ResponseDtoSucursal transformarSucursalResponseDto(Sucursal sucursal) throws Exception{
        ResponseDtoSucursal responseDtoSucursal = null;
        try{
            if (null != sucursal){
                responseDtoSucursal = new ResponseDtoSucursal();
                responseDtoSucursal.setIdSucursalDto(sucursal.getIdSucursal());
                responseDtoSucursal.setNombreSucursalDto(sucursal.getNombreSucursal());

            }
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoSucursal;
    }

    public Sucursal transformarOptionalSucursal(Optional<Sucursal> sucursalOptional) throws Exception {
        Sucursal sucursal = null;
        try {
            if(sucursalOptional.isPresent()){
                sucursal = new Sucursal();
                sucursal.setIdSucursal(sucursalOptional.get().getIdSucursal());
                sucursal.setNombreSucursal(sucursalOptional.get().getNombreSucursal());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return sucursal;
    }

}
