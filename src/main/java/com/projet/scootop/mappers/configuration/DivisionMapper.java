package com.projet.scootop.mappers.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.configuration.Division;
import com.projet.scootop.model.configuration.DivisionDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class DivisionMapper {
	
	public Division mapTo(DivisionDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Division entity = new Division();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public DivisionDTO mapTo(Division entity) {
        Assert.notNull(entity, "The entity must not be null");
        DivisionDTO dto = new DivisionDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<DivisionDTO> mapTo(List<Division> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
