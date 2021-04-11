package com.projet.scootop.mappers.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.provider.Cameraman;
import com.projet.scootop.model.provider.CameramanDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CameramanMapper {
	
	public Cameraman mapTo(CameramanDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Cameraman entity = new Cameraman();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CameramanDTO mapTo(Cameraman entity) {
        Assert.notNull(entity, "The entity must not be null");
        CameramanDTO dto = new CameramanDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CameramanDTO> mapTo(List<Cameraman> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
