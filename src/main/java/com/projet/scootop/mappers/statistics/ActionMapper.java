package com.projet.scootop.mappers.statistics;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.model.statistics.ActionDTO;


@Component
public class ActionMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Action mapTo(ActionDTO dto) {
		    	return modelMapper.map(dto, Action.class);
    }
	
    public ActionDTO mapToDTO(Action entity) {
            	return modelMapper.map(entity, ActionDTO.class);
    }

    public List<ActionDTO> mapToDTO(List<Action> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Action> mapTo(List<ActionDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
