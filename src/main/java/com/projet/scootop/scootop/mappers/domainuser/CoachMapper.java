package com.projet.scootop.scootop.mappers.domainuser;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.model.domainuser.CoachDTO;
import java.util.List;
import java.util.stream.Collectors;

public class CoachMapper {
	
	public Coach mapTo(CoachDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Coach entity = new Coach();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public CoachDTO mapTo(Coach entity) {
        Assert.notNull(entity, "The entity must not be null");
        CoachDTO dto = new CoachDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<CoachDTO> mapTo(List<Coach> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
