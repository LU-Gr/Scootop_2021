package com.projet.scootop.mappers.services.interaction;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Follow;
import com.projet.scootop.model.services.interaction.FollowDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class FollowMapper {
	
	public Follow mapTo(FollowDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Follow entity = new Follow();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public FollowDTO mapTo(Follow entity) {
        Assert.notNull(entity, "The entity must not be null");
        FollowDTO dto = new FollowDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<FollowDTO> mapTo(List<Follow> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
