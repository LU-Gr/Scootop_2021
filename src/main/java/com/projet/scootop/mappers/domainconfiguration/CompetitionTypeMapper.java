package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.CompetitionType;
import com.projet.scootop.model.domainconfiguration.CompetitionTypeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CompetitionTypeMapper {
	
	public CompetitionType mapTo(CompetitionTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		CompetitionType entity = new CompetitionType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CompetitionTypeDTO mapTo(CompetitionType entity) {
        Assert.notNull(entity, "The entity must not be null");
        CompetitionTypeDTO dto = new CompetitionTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CompetitionTypeDTO> mapTo(List<CompetitionType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
