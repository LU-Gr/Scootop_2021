package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.Events;
import com.projet.scootop.model.services.EventsDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EventsMapper {
	
	public Events mapTo(EventsDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Events entity = new Events();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public EventsDTO mapTo(Events entity) {
        Assert.notNull(entity, "The entity must not be null");
        EventsDTO dto = new EventsDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<EventsDTO> mapTo(List<Events> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
