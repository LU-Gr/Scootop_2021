package com.projet.scootop.mappers.user.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.Analyste;
import com.projet.scootop.model.user.provider.AnalysteDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AnalysteMapper {
	
	public Analyste mapTo(AnalysteDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Analyste entity = new Analyste();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public AnalysteDTO mapTo(Analyste entity) {
        Assert.notNull(entity, "The entity must not be null");
        AnalysteDTO dto = new AnalysteDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AnalysteDTO> mapTo(List<Analyste> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
