package com.projet.scootop.mappers.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.model.user.RegisterDTO;
import com.projet.scootop.model.user.UserDTO;

@Component
public class UserMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public User mapTo(UserDTO dto) {
		return modelMapper.map(dto, User.class);
    }
	
    public UserDTO mapToDTO(User entity) {
    	return modelMapper.map(entity, UserDTO.class);
    }

    public List<UserDTO> mapToDTO(List<User> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<User> mapTo(List<UserDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
    
    public User mapToRegister(RegisterDTO dto) {
		return modelMapper.map(dto, User.class);
    }
	
    public RegisterDTO mapToRegisterDTO(User entity) {
    	return modelMapper.map(entity, RegisterDTO.class);
    }
}
