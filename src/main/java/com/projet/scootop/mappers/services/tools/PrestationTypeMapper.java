package com.projet.scootop.mappers.services.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.PrestationType;
import com.projet.scootop.model.services.tools.PrestationTypeDTO;


@Component
public class PrestationTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public PrestationType mapTo(PrestationTypeDTO dto) {
		    	return modelMapper.map(dto, PrestationType.class);
    }
	
    public PrestationTypeDTO mapToDTO(PrestationType entity) {
            	return modelMapper.map(entity, PrestationTypeDTO.class);
    }

    public List<PrestationTypeDTO> mapToDTO(List<PrestationType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<PrestationType> mapTo(List<PrestationTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
