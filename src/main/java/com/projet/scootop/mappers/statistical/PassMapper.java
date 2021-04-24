package com.projet.scootop.mappers.statistical;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.model.statistical.PassDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PassMapper {
	
	public Pass mapTo(PassDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Pass entity = new Pass();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public PassDTO mapTo(Pass entity) {
        Assert.notNull(entity, "The entity must not be null");
        PassDTO dto = new PassDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<PassDTO> mapTo(List<Pass> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
