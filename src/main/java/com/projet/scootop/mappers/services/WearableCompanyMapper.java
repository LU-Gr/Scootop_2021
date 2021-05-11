package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.WearableCompany;
import com.projet.scootop.model.services.WearableCompanyDTO;


@Component
public class WearableCompanyMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public WearableCompany mapTo(WearableCompanyDTO dto) {
		    	return modelMapper.map(dto, WearableCompany.class);
    }
	
    public WearableCompanyDTO mapToDTO(WearableCompany entity) {
            	return modelMapper.map(entity, WearableCompanyDTO.class);
    }

    public List<WearableCompanyDTO> mapToDTO(List<WearableCompany> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<WearableCompany> mapTo(List<WearableCompanyDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
