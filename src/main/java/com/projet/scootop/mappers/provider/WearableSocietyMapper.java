package com.projet.scootop.mappers.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.provider.WearableSociety;
import com.projet.scootop.model.provider.WearableSocietyDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class WearableSocietyMapper {
	
	public WearableSociety mapTo(WearableSocietyDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		WearableSociety entity = new WearableSociety();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public WearableSocietyDTO mapTo(WearableSociety entity) {
        Assert.notNull(entity, "The entity must not be null");
        WearableSocietyDTO dto = new WearableSocietyDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<WearableSocietyDTO> mapTo(List<WearableSociety> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
