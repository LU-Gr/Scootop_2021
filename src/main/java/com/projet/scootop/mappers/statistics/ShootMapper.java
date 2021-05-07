package com.projet.scootop.mappers.statistics;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistics.Shoot;
import com.projet.scootop.model.statistics.ShootDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ShootMapper {
	
	public Shoot mapTo(ShootDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Shoot entity = new Shoot();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ShootDTO mapTo(Shoot entity) {
        Assert.notNull(entity, "The entity must not be null");
        ShootDTO dto = new ShootDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ShootDTO> mapTo(List<Shoot> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
