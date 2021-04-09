package com.projet.scootop.scootop.mappers.user;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.user.Contact;
import com.projet.scootop.scootop.model.user.ContactDTO;
import java.util.List;
import java.util.stream.Collectors;

public class ContactMapper {
	
	public Contact mapTo(ContactDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Contact entity = new Contact();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ContactDTO mapTo(Contact entity) {
        Assert.notNull(entity, "The entity must not be null");
        ContactDTO dto = new ContactDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ContactDTO> mapTo(List<Contact> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
