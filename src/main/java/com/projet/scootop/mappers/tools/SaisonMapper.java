package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.model.tools.SaisonDTO;


@Component
public class SaisonMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Saison mapTo(SaisonDTO dto) {
		    	return modelMapper.map(dto, Saison.class);
    }
	
    public SaisonDTO mapToDTO(Saison entity) {
            	return modelMapper.map(entity, SaisonDTO.class);
    }

    public List<SaisonDTO> mapToDTO(List<Saison> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Saison> mapTo(List<SaisonDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
