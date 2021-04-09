package com.projet.scootop.scootop.mappers.provider;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.provider.MarketingAdvisor;
import com.projet.scootop.scootop.model.provider.MarketingAdvisorDTO;
import java.util.List;
import java.util.stream.Collectors;

public class MarketingAdvisorMapper {
	
	public MarketingAdvisor mapTo(MarketingAdvisorDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		MarketingAdvisor entity = new MarketingAdvisor();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public MarketingAdvisorDTO mapTo(MarketingAdvisor entity) {
        Assert.notNull(entity, "The entity must not be null");
        MarketingAdvisorDTO dto = new MarketingAdvisorDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<MarketingAdvisorDTO> mapTo(List<MarketingAdvisor> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
