package com.projet.scootop.mappers.tools;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.model.tools.SaisonDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class SaisonMapper {
	
	public Saison mapTo(SaisonDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Saison entity = new Saison();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public SaisonDTO mapTo(Saison entity) {
        Assert.notNull(entity, "The entity must not be null");
        SaisonDTO dto = new SaisonDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<SaisonDTO> mapTo(List<Saison> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
