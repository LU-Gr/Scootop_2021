package com.projet.scootop.mappers.user.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.user.provider.MarketingAdvisor;
import com.projet.scootop.model.user.provider.MarketingAdvisorDTO;


@Component
public class MarketingAdvisorMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public MarketingAdvisor mapTo(MarketingAdvisorDTO dto) {
		    	return modelMapper.map(dto, MarketingAdvisor.class);
    }
	
    public MarketingAdvisorDTO mapToDTO(MarketingAdvisor entity) {
            	return modelMapper.map(entity, MarketingAdvisorDTO.class);
    }

    public List<MarketingAdvisorDTO> mapToDTO(List<MarketingAdvisor> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<MarketingAdvisor> mapTo(List<MarketingAdvisorDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
