package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Stade;
import com.projet.scootop.model.configuration.StadeDTO;

@Component
public class StadeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Stade mapTo(StadeDTO dto) {
		    	return modelMapper.map(dto, Stade.class);
    }
	
    public StadeDTO mapToDTO(Stade entity) {
            	return modelMapper.map(entity, StadeDTO.class);
    }

    public List<StadeDTO> mapToDTO(List<Stade> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Stade> mapTo(List<StadeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
