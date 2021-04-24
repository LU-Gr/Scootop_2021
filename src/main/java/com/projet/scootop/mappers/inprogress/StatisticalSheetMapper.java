package com.projet.scootop.mappers.inprogress;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.model.inprogress.StatisticalSheetDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class StatisticalSheetMapper {
	
	public StatisticalSheet mapTo(StatisticalSheetDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		StatisticalSheet entity = new StatisticalSheet();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public StatisticalSheetDTO mapTo(StatisticalSheet entity) {
        Assert.notNull(entity, "The entity must not be null");
        StatisticalSheetDTO dto = new StatisticalSheetDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<StatisticalSheetDTO> mapTo(List<StatisticalSheet> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
