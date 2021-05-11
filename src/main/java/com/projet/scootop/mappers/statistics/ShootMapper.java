package com.projet.scootop.mappers.statistics;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Shoot;
import com.projet.scootop.model.statistics.ShootDTO;


@Component
public class ShootMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Shoot mapTo(ShootDTO dto) {
		    	return modelMapper.map(dto, Shoot.class);
    }
	
    public ShootDTO mapToDTO(Shoot entity) {
            	return modelMapper.map(entity, ShootDTO.class);
    }

    public List<ShootDTO> mapToDTO(List<Shoot> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Shoot> mapTo(List<ShootDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
