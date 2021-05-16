package com.projet.scootop.service.services.tools.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.tools.video.Video;
import com.projet.scootop.mappers.services.tools.video.VideoMapper;
import com.projet.scootop.model.services.tools.video.VideoDTO;
import com.projet.scootop.repository.services.tools.video.VideoRepository;

@Service
public class VideoService {

	@Autowired VideoRepository repository;
	@Autowired VideoMapper mapper;
	
	public VideoDTO add(VideoDTO videoDTO){
		Video video = mapper.mapTo(videoDTO);
		repository.save(video);
        return mapper.mapToDTO(video);

    }
    public VideoDTO update(VideoDTO videoDTO){
    	Video video = mapper.mapTo(videoDTO);
    	repository.save(video);
        return mapper.mapToDTO(video);

    }
    public VideoDTO get(Long id){
    	Video video = repository.findById(id).orElse(null);
        return mapper.mapToDTO(video);

    }
    public List<VideoDTO> getAll(){
    	List<Video> videos = repository.findAll();
        return mapper.mapToDTO(videos);
    }
    
    public String delete(Long id){
    	Video video = repository.findById(id).orElse(null);
        if(video==null){
            return null;
        }
        repository.deleteById(id);

        return "Deleted";
    }
}
