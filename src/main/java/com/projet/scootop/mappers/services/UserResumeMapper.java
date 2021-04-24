package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.UserResume;
import com.projet.scootop.model.services.UserResumeDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserResumeMapper {
	
	public UserResume mapTo(UserResumeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		UserResume entity = new UserResume();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public UserResumeDTO mapTo(UserResume entity) {
        Assert.notNull(entity, "The entity must not be null");
        UserResumeDTO dto = new UserResumeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<UserResumeDTO> mapTo(List<UserResume> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
