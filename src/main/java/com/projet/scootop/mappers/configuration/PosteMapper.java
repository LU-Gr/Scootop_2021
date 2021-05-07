package com.projet.scootop.mappers.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.model.configuration.PosteDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PosteMapper {
	
	public Poste mapTo(PosteDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Poste entity = new Poste();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public PosteDTO mapTo(Poste entity) {
        Assert.notNull(entity, "The entity must not be null");
        PosteDTO dto = new PosteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<PosteDTO> mapTo(List<Poste> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
