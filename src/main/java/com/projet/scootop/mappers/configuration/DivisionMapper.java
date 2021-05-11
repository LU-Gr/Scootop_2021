package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Division;
import com.projet.scootop.model.configuration.DivisionDTO;


@Component
public class DivisionMapper {
	
	@Autowired private ModelMapper modelMapper;
	
    public Division mapTo(DivisionDTO dto) {
		    	return modelMapper.map(dto, Division.class);
    }
	
    public DivisionDTO mapToDTO(Division entity) {
            	return modelMapper.map(entity, DivisionDTO.class);
    }

    public List<DivisionDTO> mapToDTO(List<Division> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Division> mapTo(List<DivisionDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
