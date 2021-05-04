package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.MatchSheet;
import com.projet.scootop.model.domainconfiguration.MatchSheetDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class MatchSheetMapper {
	
	public MatchSheet mapTo(MatchSheetDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		MatchSheet entity = new MatchSheet();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public MatchSheetDTO mapTo(MatchSheet entity) {
        Assert.notNull(entity, "The entity must not be null");
        MatchSheetDTO dto = new MatchSheetDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<MatchSheetDTO> mapTo(List<MatchSheet> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
