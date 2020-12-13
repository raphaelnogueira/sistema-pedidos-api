package br.com.pedidos.application.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.pedidos.application.interfaces.IMapper;

@Service
public class Mapper implements IMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        ModelMapper mapper = new ModelMapper();
        if(source == null) {
            return null;
        }

        return mapper.map(source, destinationType);
    }
    
}
