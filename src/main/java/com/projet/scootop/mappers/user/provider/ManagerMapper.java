package com.projet.scootop.mappers.user.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Manager;
import com.projet.scootop.model.user.provider.ManagerDTO;


@Component
public class ManagerMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Manager mapTo(ManagerDTO dto) {
		    	return modelMapper.map(dto, Manager.class);
    }
	
    public ManagerDTO mapToDTO(Manager entity) {
            	return modelMapper.map(entity, ManagerDTO.class);
    }

    public List<ManagerDTO> mapToDTO(List<Manager> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Manager> mapTo(List<ManagerDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
