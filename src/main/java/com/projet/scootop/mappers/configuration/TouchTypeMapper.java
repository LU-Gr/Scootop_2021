package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.model.configuration.TouchTypeDTO;


@Component
public class TouchTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public TouchType mapTo(TouchTypeDTO dto) {
		    	return modelMapper.map(dto, TouchType.class);
    }
	
    public TouchTypeDTO mapToDTO(TouchType entity) {
            	return modelMapper.map(entity, TouchTypeDTO.class);
    }

    public List<TouchTypeDTO> mapToDTO(List<TouchType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<TouchType> mapTo(List<TouchTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }

}
