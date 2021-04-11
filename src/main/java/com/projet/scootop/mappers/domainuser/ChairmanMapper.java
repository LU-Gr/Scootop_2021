package com.projet.scootop.mappers.domainuser;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainuser.Chairman;
import com.projet.scootop.model.domainuser.ChairmanDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ChairmanMapper {
	
	public Chairman mapTo(ChairmanDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Chairman entity = new Chairman();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ChairmanDTO mapTo(Chairman entity) {
        Assert.notNull(entity, "The entity must not be null");
        ChairmanDTO dto = new ChairmanDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ChairmanDTO> mapTo(List<Chairman> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
