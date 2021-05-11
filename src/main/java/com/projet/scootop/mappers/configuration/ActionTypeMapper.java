package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.model.configuration.ActionTypeDTO;


@Component
public class ActionTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public ActionType mapTo(ActionTypeDTO dto) {
		    	return modelMapper.map(dto, ActionType.class);
    }
	
    public ActionTypeDTO mapToDTO(ActionType entity) {
            	return modelMapper.map(entity, ActionTypeDTO.class);
    }

    public List<ActionTypeDTO> mapToDTO(List<ActionType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<ActionType> mapTo(List<ActionTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
