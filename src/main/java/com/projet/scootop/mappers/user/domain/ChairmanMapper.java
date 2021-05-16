package com.projet.scootop.mappers.user.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domain.Chairman;
import com.projet.scootop.model.user.domain.ChairmanDTO;


@Component
public class ChairmanMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Chairman mapTo(ChairmanDTO dto) {
		    	return modelMapper.map(dto, Chairman.class);
    }
	
    public ChairmanDTO mapToDTO(Chairman entity) {
            	return modelMapper.map(entity, ChairmanDTO.class);
    }

    public List<ChairmanDTO> mapToDTO(List<Chairman> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Chairman> mapTo(List<ChairmanDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
