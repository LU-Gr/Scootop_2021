package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Competition;
import com.projet.scootop.model.tools.CompetitionDTO;


@Component
public class CompetitionMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Competition mapTo(CompetitionDTO dto) {
		    	return modelMapper.map(dto, Competition.class);
    }
	
    public CompetitionDTO mapToDTO(Competition entity) {
            	return modelMapper.map(entity, CompetitionDTO.class);
    }

    public List<CompetitionDTO> mapToDTO(List<Competition> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Competition> mapTo(List<CompetitionDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
