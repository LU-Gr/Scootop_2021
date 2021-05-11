package com.projet.scootop.mappers.services.tools.video;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.model.services.tools.video.VideoDTO;


@Component
public class VideoMapper {
	
	@Autowired private ModelMapper modelMapper;
	
	public Video mapTo(VideoDTO dto) {
		    	return modelMapper.map(dto, Video.class);
    }
	
    public VideoDTO mapToDTO(Video entity) {
            	return modelMapper.map(entity, VideoDTO.class);
    }

    public List<VideoDTO> mapToDTO(List<Video> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<Video> mapTo(List<VideoDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
