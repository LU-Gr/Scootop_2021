package com.projet.scootop.mappers.configuration;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;


@Component
public class CompetitionTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public CompetitionType mapTo(CompetitionTypeDTO dto) {
		    	return modelMapper.map(dto, CompetitionType.class);
    }
	
    public CompetitionTypeDTO mapToDTO(CompetitionType entity) {
            	return modelMapper.map(entity, CompetitionTypeDTO.class);
    }

    public List<CompetitionTypeDTO> mapToDTO(List<CompetitionType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<CompetitionType> mapTo(List<CompetitionTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
