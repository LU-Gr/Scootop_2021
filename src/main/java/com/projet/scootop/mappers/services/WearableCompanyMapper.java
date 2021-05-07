package com.projet.scootop.mappers.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.WearableCompany;
import com.projet.scootop.model.services.WearableCompanyDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class WearableCompanyMapper {
	
	public WearableCompany mapTo(WearableCompanyDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		WearableCompany entity = new WearableCompany();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public WearableCompanyDTO mapTo(WearableCompany entity) {
        Assert.notNull(entity, "The entity must not be null");
        WearableCompanyDTO dto = new WearableCompanyDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<WearableCompanyDTO> mapTo(List<WearableCompany> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
