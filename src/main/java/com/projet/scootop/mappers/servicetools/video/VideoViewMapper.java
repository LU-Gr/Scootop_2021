package com.projet.scootop.mappers.servicetools.video;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.servicetools.video.VideoView;
import com.projet.scootop.model.servicetools.video.VideoViewDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class VideoViewMapper {
	
	public VideoView mapTo(VideoViewDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		VideoView entity = new VideoView();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public VideoViewDTO mapTo(VideoView entity) {
        Assert.notNull(entity, "The entity must not be null");
        VideoViewDTO dto = new VideoViewDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<VideoViewDTO> mapTo(List<VideoView> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
