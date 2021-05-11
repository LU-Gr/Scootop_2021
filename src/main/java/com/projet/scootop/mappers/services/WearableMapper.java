package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.model.services.WearableDTO;


@Component
public class WearableMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Wearable mapTo(WearableDTO dto) {
		    	return modelMapper.map(dto, Wearable.class);
    }
	
    public WearableDTO mapToDTO(Wearable entity) {
            	return modelMapper.map(entity, WearableDTO.class);
    }

    public List<WearableDTO> mapToDTO(List<Wearable> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Wearable> mapTo(List<WearableDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
