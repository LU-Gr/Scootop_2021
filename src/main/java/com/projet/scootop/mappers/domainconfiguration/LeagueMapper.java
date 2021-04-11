package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.League;
import com.projet.scootop.model.domainconfiguration.LeagueDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LeagueMapper {
	
	public League mapTo(LeagueDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		League entity = new League();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public LeagueDTO mapTo(League entity) {
        Assert.notNull(entity, "The entity must not be null");
        LeagueDTO dto = new LeagueDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<LeagueDTO> mapTo(List<League> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
