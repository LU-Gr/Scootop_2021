package com.projet.scootop.mappers.servicetools;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.servicetools.PrestationType;
import com.projet.scootop.model.servicetools.PrestationTypeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PrestationTypeMapper {
	
	public PrestationType mapTo(PrestationTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		PrestationType entity = new PrestationType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public PrestationTypeDTO mapTo(PrestationType entity) {
        Assert.notNull(entity, "The entity must not be null");
        PrestationTypeDTO dto = new PrestationTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<PrestationTypeDTO> mapTo(List<PrestationType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
