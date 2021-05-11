package com.projet.scootop.mappers.tools;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.model.tools.ClubDTO;


@Component
public class ClubMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Club mapTo(ClubDTO dto) {
		    	return modelMapper.map(dto, Club.class);
    }
	
    public ClubDTO mapToDTO(Club entity) {
            	return modelMapper.map(entity, ClubDTO.class);
    }

    public List<ClubDTO> mapToDTO(List<Club> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Club> mapTo(List<ClubDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
