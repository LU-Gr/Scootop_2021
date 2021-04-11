package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.model.domainconfiguration.CategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
	
	public Category mapTo(CategoryDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CategoryDTO mapTo(Category entity) {
        Assert.notNull(entity, "The entity must not be null");
        CategoryDTO dto = new CategoryDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CategoryDTO> mapTo(List<Category> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
