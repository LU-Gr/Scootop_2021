package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.model.configuration.TouchTypeDTO;


@Component
public class TouchTypeMapper {
	
	public TouchType mapTo(TouchTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		TouchType entity = new TouchType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public TouchTypeDTO mapTo(TouchType entity) {
        Assert.notNull(entity, "The entity must not be null");
        TouchTypeDTO dto = new TouchTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<TouchTypeDTO> mapTo(List<TouchType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }

}
