package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.model.tools.StatisticalSheetDTO;

@Component
public class StatisticalSheetMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public StatisticalSheet mapTo(StatisticalSheetDTO dto) {
		    	return modelMapper.map(dto, StatisticalSheet.class);
    }
	
    public StatisticalSheetDTO mapToDTO(StatisticalSheet entity) {
            	return modelMapper.map(entity, StatisticalSheetDTO.class);
    }

    public List<StatisticalSheetDTO> mapToDTO(List<StatisticalSheet> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<StatisticalSheet> mapTo(List<StatisticalSheetDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
