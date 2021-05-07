package com.projet.scootop.mappers.user.domainuser;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.domainuser.Scoot;
import com.projet.scootop.model.user.domainuser.ScootDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ScootMapper {
	
	public Scoot mapTo(ScootDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Scoot entity = new Scoot();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public ScootDTO mapTo(Scoot entity) {
        Assert.notNull(entity, "The entity must not be null");
        ScootDTO dto = new ScootDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<ScootDTO> mapTo(List<Scoot> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
