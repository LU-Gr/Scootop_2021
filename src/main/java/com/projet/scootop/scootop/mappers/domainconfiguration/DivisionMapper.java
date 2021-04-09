package com.projet.scootop.scootop.mappers.domainconfiguration;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.domainconfiguration.Division;
import com.projet.scootop.scootop.model.domainconfiguration.DivisionsDTO;
import java.util.List;
import java.util.stream.Collectors;

public class DivisionMapper {
	
	public Division mapTo(DivisionsDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Division entity = new Division();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public DivisionsDTO mapTo(Division entity) {
        Assert.notNull(entity, "The entity must not be null");
        DivisionsDTO dto = new DivisionsDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<DivisionsDTO> mapTo(List<Division> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
