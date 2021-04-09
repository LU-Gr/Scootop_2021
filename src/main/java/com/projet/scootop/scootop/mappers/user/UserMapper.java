package com.projet.scootop.scootop.mappers.user;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.model.user.UserDTO;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
	
	public User mapTo(UserDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public UserDTO mapTo(User entity) {
        Assert.notNull(entity, "The entity must not be null");
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<UserDTO> mapTo(List<User> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
