package com.projet.scootop.mappers.tools;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.model.tools.MatchDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class MatchMapper {
	
	public Match mapTo(MatchDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Match entity = new Match();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public MatchDTO mapTo(Match entity) {
        Assert.notNull(entity, "The entity must not be null");
        MatchDTO dto = new MatchDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<MatchDTO> mapTo(List<Match> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
