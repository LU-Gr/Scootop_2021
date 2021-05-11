package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.model.services.ShortlistDTO;


@Component
public class ShortlistMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Shortlist mapTo(ShortlistDTO dto) {
		    	return modelMapper.map(dto, Shortlist.class);
    }
	
    public ShortlistDTO mapToDTO(Shortlist entity) {
            	return modelMapper.map(entity, ShortlistDTO.class);
    }

    public List<ShortlistDTO> mapToDTO(List<Shortlist> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Shortlist> mapTo(List<ShortlistDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
