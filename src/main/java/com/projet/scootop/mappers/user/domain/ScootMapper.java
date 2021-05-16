package com.projet.scootop.mappers.user.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domain.Scoot;
import com.projet.scootop.model.user.domain.ScootDTO;


@Component
public class ScootMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Scoot mapTo(ScootDTO dto) {
		    	return modelMapper.map(dto, Scoot.class);
    }
	
    public ScootDTO mapToDTO(Scoot entity) {
            	return modelMapper.map(entity, ScootDTO.class);
    }

    public List<ScootDTO> mapToDTO(List<Scoot> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Scoot> mapTo(List<ScootDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
