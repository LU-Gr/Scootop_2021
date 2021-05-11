package com.projet.scootop.mappers.services.interaction;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Invite;
import com.projet.scootop.model.services.interaction.InviteDTO;


@Component
public class InviteMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Invite mapTo(InviteDTO dto) {
		    	return modelMapper.map(dto, Invite.class);
    }
	
    public InviteDTO mapToDTO(Invite entity) {
            	return modelMapper.map(entity, InviteDTO.class);
    }

    public List<InviteDTO> mapToDTO(List<Invite> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Invite> mapTo(List<InviteDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
