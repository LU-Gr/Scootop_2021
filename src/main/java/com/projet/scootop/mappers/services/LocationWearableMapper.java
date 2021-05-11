package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.LocationWearable;
import com.projet.scootop.model.services.LocationWearableDTO;

@Component
public class LocationWearableMapper {
	
	@Autowired private ModelMapper modelMapper;

	public LocationWearable mapTo(LocationWearableDTO dto) {
		    	return modelMapper.map(dto, LocationWearable.class);
    }
	
    public LocationWearableDTO mapToDTO(LocationWearable entity) {
            	return modelMapper.map(entity, LocationWearableDTO.class);
    }

    public List<LocationWearableDTO> mapToDTO(List<LocationWearable> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<LocationWearable> mapTo(List<LocationWearableDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
