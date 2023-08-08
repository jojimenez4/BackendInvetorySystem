package com.project.mapping;

import com.project.dto.ReqDtoRol;
import com.project.dto.ResponseDtoRol;
import com.project.model.Rol;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoRol {
    public Rol transformDtotoModel(ReqDtoRol reqDtoRol)  throws Exception{
        Rol rolLocal;
        try{
            rolLocal = new Rol();
            rolLocal.setCargo(reqDtoRol.getCargoDto());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return rolLocal;
    }

    public ResponseDtoRol transformModelaResponse(Rol rol) throws Exception{
        ResponseDtoRol responseDtoRol;
        try{
            responseDtoRol = new ResponseDtoRol();
            responseDtoRol.setCargoDto(rol.getCargo());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoRol;
    }

    public Rol transformOptionalaModel(Optional<Rol> optionalRol) throws Exception{
        Rol rolLocal = null;
        try{
            if(optionalRol.isPresent()){
                rolLocal = new Rol();
                rolLocal.setIdRol(optionalRol.get().getIdRol());
                rolLocal.setCargo(optionalRol.get().getCargo());
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return rolLocal;
    }
}
