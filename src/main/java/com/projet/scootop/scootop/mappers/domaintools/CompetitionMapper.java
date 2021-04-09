package com.projet.scootop.scootop.mappers.domaintools;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.model.domaintools.CompetitionDTO;
import java.util.List;
import java.util.stream.Collectors;

public class CompetitionMapper {
	
	public Competition mapTo(CompetitionDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Competition entity = new Competition();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CompetitionDTO mapTo(Competition entity) {
        Assert.notNull(entity, "The entity must not be null");
        CompetitionDTO dto = new CompetitionDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CompetitionDTO> mapTo(List<Competition> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
