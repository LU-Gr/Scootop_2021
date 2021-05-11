package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.model.tools.TeamDTO;


@Component
public class TeamMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Team mapTo(TeamDTO dto) {
		    	return modelMapper.map(dto, Team.class);
    }
	
    public TeamDTO mapToDTO(Team entity) {
            	return modelMapper.map(entity, TeamDTO.class);
    }

    public List<TeamDTO> mapToDTO(List<Team> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Team> mapTo(List<TeamDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
