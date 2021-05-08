package com.projet.scootop.mappers.user.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Analyst;
import com.projet.scootop.model.user.provider.AnalysteDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AnalysteMapper {
	
	public Analyst mapTo(AnalysteDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Analyst entity = new Analyst();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public AnalysteDTO mapTo(Analyst entity) {
        Assert.notNull(entity, "The entity must not be null");
        AnalysteDTO dto = new AnalysteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AnalysteDTO> mapTo(List<Analyst> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
