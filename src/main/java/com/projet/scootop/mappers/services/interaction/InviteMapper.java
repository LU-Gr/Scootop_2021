package com.projet.scootop.mappers.services.interaction;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Invite;
import com.projet.scootop.model.services.interaction.InviteDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class InviteMapper {
	
	public Invite mapTo(InviteDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Invite entity = new Invite();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public InviteDTO mapTo(Invite entity) {
        Assert.notNull(entity, "The entity must not be null");
        InviteDTO dto = new InviteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<InviteDTO> mapTo(List<Invite> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
