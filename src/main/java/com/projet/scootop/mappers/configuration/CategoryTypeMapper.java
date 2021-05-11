package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.model.configuration.CategoryTypeDTO;


@Component
public class CategoryTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public CategoryType mapTo(CategoryTypeDTO dto) {
		    	return modelMapper.map(dto, CategoryType.class);
    }
	
    public CategoryTypeDTO mapToDTO(CategoryType entity) {
            	return modelMapper.map(entity, CategoryTypeDTO.class);
    }

    public List<CategoryTypeDTO> mapToDTO(List<CategoryType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<CategoryType> mapTo(List<CategoryTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
