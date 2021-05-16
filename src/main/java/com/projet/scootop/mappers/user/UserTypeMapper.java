package com.projet.scootop.mappers.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.UserType;
import com.projet.scootop.model.user.UserTypeDTO;


@Component
public class UserTypeMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public UserType mapTo(UserTypeDTO dto) {
		return modelMapper.map(dto, UserType.class);
    }
	
    public UserTypeDTO mapToDTO(UserType entity) {
    	return modelMapper.map(entity, UserTypeDTO.class);
    }

    public List<UserTypeDTO> mapToDTO(List<UserType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<UserType> mapTo(List<UserTypeDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
