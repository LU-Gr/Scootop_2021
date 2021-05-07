package com.projet.scootop.mappers.services.tools.video;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.model.services.tools.video.VideoDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class VideoMapper {
	
	public Video mapTo(VideoDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Video entity = new Video();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public VideoDTO mapTo(Video entity) {
        Assert.notNull(entity, "The entity must not be null");
        VideoDTO dto = new VideoDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<VideoDTO> mapTo(List<Video> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
