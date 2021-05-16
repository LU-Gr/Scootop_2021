package com.projet.scootop.mappers.user.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domain.Coach;
import com.projet.scootop.model.user.domain.CoachDTO;


@Component
public class CoachMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Coach mapTo(CoachDTO dto) {
		    	return modelMapper.map(dto, Coach.class);
    }
	
    public CoachDTO mapToDTO(Coach entity) {
            	return modelMapper.map(entity, CoachDTO.class);
    }

    public List<CoachDTO> mapToDTO(List<Coach> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Coach> mapTo(List<CoachDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
