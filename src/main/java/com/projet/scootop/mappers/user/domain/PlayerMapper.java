package com.projet.scootop.mappers.user.domain;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.model.user.domain.PlayerDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PlayerMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Player mapTo(PlayerDTO dto) {
		    	return modelMapper.map(dto, Player.class);
    }
	
    public PlayerDTO mapToDTO(Player entity) {
    	    	return modelMapper.map(entity, PlayerDTO.class);
    }

    public List<PlayerDTO> mapToDTO(List<Player> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Player> mapTo(List<PlayerDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
