package com.projet.scootop.mappers.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.LocationWearable;
import com.projet.scootop.model.services.LocationWearableDTO;

@Component
public class LocationWearableMapper {

	public LocationWearable mapTo(LocationWearableDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		LocationWearable entity = new LocationWearable();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public LocationWearableDTO mapTo(LocationWearable entity) {
        Assert.notNull(entity, "The entity must not be null");
        LocationWearableDTO dto = new LocationWearableDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<LocationWearableDTO> mapTo(List<LocationWearable> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
