package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.model.services.EventDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EventsMapper {
	
	public Event mapTo(EventDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Event entity = new Event();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public EventDTO mapTo(Event entity) {
        Assert.notNull(entity, "The entity must not be null");
        EventDTO dto = new EventDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<EventDTO> mapTo(List<Event> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
