package com.projet.scootop.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.model.domainconfiguration.ClubDTO;
import java.util.List;
import java.util.stream.Collectors;

public class ClubMapper {
	
	public Club mapTo(ClubDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Club entity = new Club();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ClubDTO mapTo(Club entity) {
        Assert.notNull(entity, "The entity must not be null");
        ClubDTO dto = new ClubDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ClubDTO> mapTo(List<Club> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
