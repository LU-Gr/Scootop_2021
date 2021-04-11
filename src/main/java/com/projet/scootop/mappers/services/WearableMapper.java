package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.model.services.WearableDTO;

import java.util.List;
import java.util.stream.Collectors;

public class WearableMapper {
	
	public Wearable mapTo(WearableDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Wearable entity = new Wearable();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public WearableDTO mapTo(Wearable entity) {
        Assert.notNull(entity, "The entity must not be null");
        WearableDTO dto = new WearableDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<WearableDTO> mapTo(List<Wearable> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
