package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.ComparatorParams;
import com.projet.scootop.model.services.ComparatorParamsDTO;

@Component
public class ComparatorParamsMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public ComparatorParams mapTo(ComparatorParamsDTO dto) {
		return modelMapper.map(dto, ComparatorParams.class);
    }
	
    public ComparatorParamsDTO mapToDTO(ComparatorParams entity) {
    	return modelMapper.map(entity, ComparatorParamsDTO.class);
    }

    public List<ComparatorParamsDTO> mapToDTO(List<ComparatorParams> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<ComparatorParams> mapTo(List<ComparatorParamsDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }

}
