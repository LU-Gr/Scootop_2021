package com.projet.scootop.mappers.statistics;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Pass;
import com.projet.scootop.model.statistics.PassDTO;


@Component
public class PassMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Pass mapTo(PassDTO dto) {
		    	return modelMapper.map(dto, Pass.class);
    }
	
    public PassDTO mapToDTO(Pass entity) {
            	return modelMapper.map(entity, PassDTO.class);
    }

    public List<PassDTO> mapToDTO(List<Pass> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Pass> mapTo(List<PassDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
