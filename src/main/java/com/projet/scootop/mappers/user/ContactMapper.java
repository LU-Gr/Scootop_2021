package com.projet.scootop.mappers.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.model.user.ContactDTO;

@Component
public class ContactMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Contact mapTo(ContactDTO dto) {
		    	return modelMapper.map(dto, Contact.class);
    }
	
    public ContactDTO mapToDTO(Contact entity) {
            	return modelMapper.map(entity, ContactDTO.class);
    }

    public List<ContactDTO> mapToDTO(List<Contact> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Contact> mapTo(List<ContactDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
