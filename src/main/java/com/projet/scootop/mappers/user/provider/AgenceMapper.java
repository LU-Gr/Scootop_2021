package com.projet.scootop.mappers.user.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Agence;
import com.projet.scootop.model.user.provider.AgenceDTO;


@Component
public class AgenceMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Agence mapTo(AgenceDTO dto) {
		    	return modelMapper.map(dto, Agence.class);
    }
	
    public AgenceDTO mapToDTO(Agence entity) {
            	return modelMapper.map(entity, AgenceDTO.class);
    }

    public List<AgenceDTO> mapToDTO(List<Agence> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Agence> mapTo(List<AgenceDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
