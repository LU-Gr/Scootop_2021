package com.projet.scootop.mappers.services.tools.video;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.video.SearchKeyWord;
import com.projet.scootop.model.services.tools.video.SearchKeyWordDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class SearchKeyWordMapper {
	
	public SearchKeyWord mapTo(SearchKeyWordDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		SearchKeyWord entity = new SearchKeyWord();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public SearchKeyWordDTO mapTo(SearchKeyWord entity) {
        Assert.notNull(entity, "The entity must not be null");
        SearchKeyWordDTO dto = new SearchKeyWordDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<SearchKeyWordDTO> mapTo(List<SearchKeyWord> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
