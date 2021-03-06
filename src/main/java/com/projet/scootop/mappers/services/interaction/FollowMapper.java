package com.projet.scootop.mappers.services.interaction;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Follow;
import com.projet.scootop.model.services.interaction.FollowDTO;


@Component
public class FollowMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Follow mapTo(FollowDTO dto) {
		    	return modelMapper.map(dto, Follow.class);
    }
	
    public FollowDTO mapToDTO(Follow entity) {
            	return modelMapper.map(entity, FollowDTO.class);
    }

    public List<FollowDTO> mapToDTO(List<Follow> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Follow> mapTo(List<FollowDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
