package com.projet.scootop.mappers.statistical;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistical.Shoot;
import com.projet.scootop.model.statistical.ShootDTO;

import java.util.List;
import java.util.stream.Collectors;

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
