package com.projet.scootop.scootop.mappers.servicetools.video;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.servicetools.video.SearchKeyWord;
import com.projet.scootop.scootop.model.servicetools.video.SearchKeyWordDTO;
import java.util.List;
import java.util.stream.Collectors;

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
