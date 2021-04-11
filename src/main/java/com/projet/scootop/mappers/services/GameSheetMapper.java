package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.GameSheet;
import com.projet.scootop.model.services.GameSheetDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GameSheetMapper {
	
	public GameSheet mapTo(GameSheetDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		GameSheet entity = new GameSheet();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public GameSheetDTO mapTo(GameSheet entity) {
        Assert.notNull(entity, "The entity must not be null");
        GameSheetDTO dto = new GameSheetDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<GameSheetDTO> mapTo(List<GameSheet> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
