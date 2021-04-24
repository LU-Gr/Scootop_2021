package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.model.domainconfiguration.TeamDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class TeamMapper {
	
	public Team mapTo(TeamDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Team entity = new Team();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public TeamDTO mapTo(Team entity) {
        Assert.notNull(entity, "The entity must not be null");
        TeamDTO dto = new TeamDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<TeamDTO> mapTo(List<Team> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
