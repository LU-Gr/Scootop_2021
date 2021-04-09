package com.projet.scootop.scootop.mappers.statistical;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.statistical.Action;
import com.projet.scootop.scootop.model.statistical.ActionDTO;
import java.util.List;
import java.util.stream.Collectors;

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
