package com.projet.scootop.mappers.services.interaction;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Alert;
import com.projet.scootop.model.services.interaction.AlertDTO;


@Component
public class AlertMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Alert mapTo(AlertDTO dto) {
		    	return modelMapper.map(dto, Alert.class);
    }
	
    public AlertDTO mapToDTO(Alert entity) {
            	return modelMapper.map(entity, AlertDTO.class);
    }

    public List<AlertDTO> mapToDTO(List<Alert> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Alert> mapTo(List<AlertDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
