package com.projet.scootop.mappers.services.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.AgenceType;
import com.projet.scootop.model.services.tools.AgenceTypeDTO;


@Component
public class AgenceTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public AgenceType mapTo(AgenceTypeDTO dto) {
		    	return modelMapper.map(dto, AgenceType.class);
    }
	
    public AgenceTypeDTO mapToDTO(AgenceType entity) {
            	return modelMapper.map(entity, AgenceTypeDTO.class);
    }

    public List<AgenceTypeDTO> mapToDTO(List<AgenceType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<AgenceType> mapTo(List<AgenceTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
