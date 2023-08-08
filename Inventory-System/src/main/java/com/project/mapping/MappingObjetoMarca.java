package com.project.mapping;

import com.project.dto.ReqDtoMarca;
import com.project.dto.ResponseDtoMarca;
import com.project.model.Marca;
import com.project.util.Constant;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingObjetoMarca {
    public Marca transformDtoToModel(ReqDtoMarca reqDtoMarca) throws Exception {
        Marca marcaLocal;
        try{
            marcaLocal = new Marca(); 
            marcaLocal.setNombreMarca((reqDtoMarca.getNombreMarcaDto()));

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);

        }
        return marcaLocal;
    }

    public ResponseDtoMarca transformModelaResponse(Marca marca) throws Exception{
            ResponseDtoMarca responseDtoMarca;
        try{
            responseDtoMarca = new ResponseDtoMarca();
            responseDtoMarca.setMarcaDto(marca.getNombreMarca());

        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return responseDtoMarca;
    }

    public Marca transformOptionalaModel(Optional<Marca> optionalMarca) throws Exception {
        Marca marcaLocal = null;
        try{
            if(optionalMarca.isPresent()){
                marcaLocal = new Marca();
                marcaLocal.setIdMarca(optionalMarca.get().getIdMarca());
                marcaLocal.setNombreMarca(optionalMarca.get().getNombreMarca());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return marcaLocal;
    }
}
