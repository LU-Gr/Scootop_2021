package com.projet.scootop.mappers.statistics;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.model.statistics.GoalDTO;


@Component
public class GoalMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Goal mapTo(GoalDTO dto) {
		    	return modelMapper.map(dto, Goal.class);
    }
	
    public GoalDTO mapToDTO(Goal entity) {
            	return modelMapper.map(entity, GoalDTO.class);
    }

    public List<GoalDTO> mapToDTO(List<Goal> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Goal> mapTo(List<GoalDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
