package com.projet.scootop.mappers.user;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.UserType;
import com.projet.scootop.model.user.UserTypeDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserTypeMapper {
	
	public UserType mapTo(UserTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		UserType entity = new UserType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public UserTypeDTO mapTo(UserType entity) {
        Assert.notNull(entity, "The entity must not be null");
        UserTypeDTO dto = new UserTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<UserTypeDTO> mapTo(List<UserType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
