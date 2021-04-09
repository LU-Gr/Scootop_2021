package com.projet.scootop.scootop.mappers.servicetools;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.servicetools.AgenceType;
import com.projet.scootop.scootop.model.servicetools.AgenceTypeDTO;
import java.util.List;
import java.util.stream.Collectors;

public class AgenceTypeMapper {
	
	public AgenceType mapTo(AgenceTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		AgenceType entity = new AgenceType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public AgenceTypeDTO mapTo(AgenceType entity) {
        Assert.notNull(entity, "The entity must not be null");
        AgenceTypeDTO dto = new AgenceTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AgenceTypeDTO> mapTo(List<AgenceType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
