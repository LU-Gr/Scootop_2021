package com.projet.scootop.mappers.statistics;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.model.statistics.GoalDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class GoalMapper {
	
	public Goal mapTo(GoalDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Goal entity = new Goal();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public GoalDTO mapTo(Goal entity) {
        Assert.notNull(entity, "The entity must not be null");
        GoalDTO dto = new GoalDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<GoalDTO> mapTo(List<Goal> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
