package com.projet.scootop.mappers.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.model.configuration.CategoryTypeDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CategoryTypeMapper {
	
	public CategoryType mapTo(CategoryTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		CategoryType entity = new CategoryType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CategoryTypeDTO mapTo(CategoryType entity) {
        Assert.notNull(entity, "The entity must not be null");
        CategoryTypeDTO dto = new CategoryTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CategoryTypeDTO> mapTo(List<CategoryType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}