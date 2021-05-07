package com.projet.scootop.mappers.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.model.configuration.ActionTypeDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ActionTypeMapper {
	
	public ActionType mapTo(ActionTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		ActionType entity = new ActionType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ActionTypeDTO mapTo(ActionType entity) {
        Assert.notNull(entity, "The entity must not be null");
        ActionTypeDTO dto = new ActionTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ActionTypeDTO> mapTo(List<ActionType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
