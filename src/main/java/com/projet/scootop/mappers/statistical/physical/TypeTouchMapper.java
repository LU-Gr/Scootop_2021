package com.projet.scootop.mappers.statistical.physical;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistical.physical.TypeTouch;
import com.projet.scootop.model.statistical.physical.TypeTouchDTO;


@Component
public class TypeTouchMapper {
	
	public TypeTouch mapTo(TypeTouchDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		TypeTouch entity = new TypeTouch();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public TypeTouchDTO mapTo(TypeTouch entity) {
        Assert.notNull(entity, "The entity must not be null");
        TypeTouchDTO dto = new TypeTouchDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<TypeTouchDTO> mapTo(List<TypeTouch> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }

}
