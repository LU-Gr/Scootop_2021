package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.model.services.EventDTO;


@Component
public class EventMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Event mapTo(EventDTO dto) {
		    	return modelMapper.map(dto, Event.class);
    }
	
    public EventDTO mapToDTO(Event entity) {
            	return modelMapper.map(entity, EventDTO.class);
    }

    public List<EventDTO> mapToDTO(List<Event> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Event> mapTo(List<EventDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
