package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.model.configuration.CategoryDTO;


@Component
public class CategoryMapper {
	
	@Autowired private ModelMapper modelMapper;

	public Category mapTo(CategoryDTO dto) {
		    	return modelMapper.map(dto, Category.class);
    }
	
    public CategoryDTO mapToDTO(Category entity) {
            	return modelMapper.map(entity, CategoryDTO.class);
    }

    public List<CategoryDTO> mapToDTO(List<Category> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Category> mapTo(List<CategoryDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
