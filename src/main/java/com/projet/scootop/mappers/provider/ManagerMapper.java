package com.projet.scootop.mappers.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.provider.Manager;
import com.projet.scootop.model.provider.ManagerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerMapper {
	
	public Manager mapTo(ManagerDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Manager entity = new Manager();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ManagerDTO mapTo(Manager entity) {
        Assert.notNull(entity, "The entity must not be null");
        ManagerDTO dto = new ManagerDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ManagerDTO> mapTo(List<Manager> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
