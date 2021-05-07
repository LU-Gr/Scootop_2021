package com.projet.scootop.mappers.user.domainuser;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domainuser.Coach;
import com.projet.scootop.model.user.domainuser.CoachDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
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
