package com.projet.scootop.mappers.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Stade;
import com.projet.scootop.model.configuration.StadeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StadeMapper {
	
	public Stade mapTo(StadeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Stade entity = new Stade();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public StadeDTO mapTo(Stade entity) {
        Assert.notNull(entity, "The entity must not be null");
        StadeDTO dto = new StadeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<StadeDTO> mapTo(List<Stade> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
