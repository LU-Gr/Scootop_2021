package com.projet.scootop.mappers.services.interaction;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.interaction.Alert;
import com.projet.scootop.model.services.interaction.AlertDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AlertMapper {
	
	public Alert mapTo(AlertDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Alert entity = new Alert();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public AlertDTO mapTo(Alert entity) {
        Assert.notNull(entity, "The entity must not be null");
        AlertDTO dto = new AlertDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<AlertDTO> mapTo(List<Alert> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
