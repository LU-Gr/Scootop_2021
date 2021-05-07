package com.projet.scootop.mappers.statistics;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.model.statistics.ActionDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ActionMapper {
	
	public Action mapTo(ActionDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Action entity = new Action();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ActionDTO mapTo(Action entity) {
        Assert.notNull(entity, "The entity must not be null");
        ActionDTO dto = new ActionDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ActionDTO> mapTo(List<Action> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
