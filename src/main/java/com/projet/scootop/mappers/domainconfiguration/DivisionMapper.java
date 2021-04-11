package com.projet.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainconfiguration.Division;
import com.projet.scootop.model.domainconfiguration.DivisionDTO;

import java.util.List;
import java.util.stream.Collectors;

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
