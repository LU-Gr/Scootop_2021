package com.projet.scootop.mappers.user.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Analyst;
import com.projet.scootop.model.user.provider.AnalysteDTO;


@Component
public class AnalysteMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Analyst mapTo(AnalysteDTO dto) {
		    	return modelMapper.map(dto, Analyst.class);
    }
	
    public AnalysteDTO mapToDTO(Analyst entity) {
            	return modelMapper.map(entity, AnalysteDTO.class);
    }

    public List<AnalysteDTO> mapToDTO(List<Analyst> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Analyst> mapTo(List<AnalysteDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
