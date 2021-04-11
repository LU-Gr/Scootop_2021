package com.projet.scootop.mappers.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.provider.Agence;
import com.projet.scootop.model.provider.AgenceDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AgenceMapper {
	
	public Agence mapTo(AgenceDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Agence entity = new Agence();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public AgenceDTO mapTo(Agence entity) {
        Assert.notNull(entity, "The entity must not be null");
        AgenceDTO dto = new AgenceDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AgenceDTO> mapTo(List<Agence> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
