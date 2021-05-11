package com.projet.scootop.mappers.services.tools.video;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.services.tools.video.VideoView;
import com.projet.scootop.model.services.tools.video.VideoViewDTO;


@Component
public class VideoViewMapper {
	
	@Autowired private ModelMapper modelMapper;	
	
	public VideoView mapTo(VideoViewDTO dto) {
		    	return modelMapper.map(dto, VideoView.class);
    }
	
    public VideoViewDTO mapToDTO(VideoView entity) {
            	return modelMapper.map(entity, VideoViewDTO.class);
    }

    public List<VideoViewDTO> mapToDTO(List<VideoView> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapToDTO(entity)).collect(Collectors.toList());
    }
    
    public List<VideoView> mapTo(List<VideoViewDTO> dtos) {
        Assert.notNull(dtos, "entities must not be null");
        return dtos.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
