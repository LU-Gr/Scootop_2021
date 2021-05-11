package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.model.tools.MatchDTO;


@Component
public class MatchMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Match mapTo(MatchDTO dto) {
		    	return modelMapper.map(dto, Match.class);
    }
	
    public MatchDTO mapToDTO(Match entity) {
            	return modelMapper.map(entity, MatchDTO.class);
    }

    public List<MatchDTO> mapToDTO(List<Match> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Match> mapTo(List<MatchDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
