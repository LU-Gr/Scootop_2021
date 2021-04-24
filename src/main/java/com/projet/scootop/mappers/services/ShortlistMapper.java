package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.model.services.ShortlistDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ShortlistMapper {
	
	public Shortlist mapTo(ShortlistDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Shortlist entity = new Shortlist();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ShortlistDTO mapTo(Shortlist entity) {
        Assert.notNull(entity, "The entity must not be null");
        ShortlistDTO dto = new ShortlistDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ShortlistDTO> mapTo(List<Shortlist> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
