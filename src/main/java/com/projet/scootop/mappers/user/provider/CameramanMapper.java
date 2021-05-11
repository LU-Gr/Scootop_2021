package com.projet.scootop.mappers.user.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Cameraman;
import com.projet.scootop.model.user.provider.CameramanDTO;


@Component
public class CameramanMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Cameraman mapTo(CameramanDTO dto) {
		    	return modelMapper.map(dto, Cameraman.class);
    }
	
    public CameramanDTO mapToDTO(Cameraman entity) {
            	return modelMapper.map(entity, CameramanDTO.class);
    }

    public List<CameramanDTO> mapToDTO(List<Cameraman> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Cameraman> mapTo(List<CameramanDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
