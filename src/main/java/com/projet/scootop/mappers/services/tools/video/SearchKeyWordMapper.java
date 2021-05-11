package com.projet.scootop.mappers.services.tools.video;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.video.SearchKeyWord;
import com.projet.scootop.model.services.tools.video.SearchKeyWordDTO;


@Component
public class SearchKeyWordMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	
	public SearchKeyWord mapTo(SearchKeyWordDTO dto) {
		    	return modelMapper.map(dto, SearchKeyWord.class);
    }
	
    public SearchKeyWordDTO mapToDTO(SearchKeyWord entity) {
            	return modelMapper.map(entity, SearchKeyWordDTO.class);
    }

    public List<SearchKeyWordDTO> mapToDTO(List<SearchKeyWord> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<SearchKeyWord> mapTo(List<SearchKeyWordDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
