package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.model.configuration.PosteDTO;


@Component
public class PosteMapper {
	
	@Autowired private ModelMapper modelMapper;

	public Poste mapTo(PosteDTO dto) {
		    	return modelMapper.map(dto, Poste.class);
    }
	
    public PosteDTO mapToDTO(Poste entity) {
            	return modelMapper.map(entity, PosteDTO.class);
    }

    public List<PosteDTO> mapToDTO(List<Poste> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Poste> mapTo(List<PosteDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
