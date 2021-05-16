package com.projet.scootop.service.services.tools.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.tools.video.VideoView;
import com.projet.scootop.mappers.services.tools.video.VideoViewMapper;
import com.projet.scootop.model.services.tools.video.VideoViewDTO;
import com.projet.scootop.repository.services.tools.video.VideoViewRepository;

@Service
public class VideoViewService {

	@Autowired VideoViewRepository repository;
	@Autowired VideoViewMapper mapper;
	
	public VideoViewDTO add(VideoViewDTO videoViewDTO){
		VideoView videoView = mapper.mapTo(videoViewDTO);
		repository.save(videoView);
        return mapper.mapToDTO(videoView);

    }
    public VideoViewDTO update(VideoViewDTO videoViewDTO){
    	VideoView videoView = mapper.mapTo(videoViewDTO);
    	repository.save(videoView);
        return mapper.mapToDTO(videoView);

    }
    public VideoViewDTO get(Long id){
    	VideoView videoView = repository.findById(id).orElse(null);
        return mapper.mapToDTO(videoView);

    }
    public List<VideoViewDTO> getAll(){
    	List<VideoView> videoViews = repository.findAll();
        return mapper.mapToDTO(videoViews);
    }
    
    public String delete(Long id){
    	VideoView videoView = repository.findById(id).orElse(null);
        if(videoView==null){
            return null;
        }
        repository.deleteById(id);

        return "Deleted";
    }
}
