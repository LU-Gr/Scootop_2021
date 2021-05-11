package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.League;
import com.projet.scootop.model.configuration.LeagueDTO;


@Component
public class LeagueMapper {
	
	@Autowired private ModelMapper modelMapper;

	public League mapTo(LeagueDTO dto) {
		    	return modelMapper.map(dto, League.class);
    }
	
    public LeagueDTO mapToDTO(League entity) {
            	return modelMapper.map(entity, LeagueDTO.class);
    }

    public List<LeagueDTO> mapToDTO(List<League> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<League> mapTo(List<LeagueDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
