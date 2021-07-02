package com.projet.scootop.service.services.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.interaction.Follow;
import com.projet.scootop.mappers.services.interaction.FollowMapper;
import com.projet.scootop.model.APIResultDTO;
import com.projet.scootop.model.services.interaction.FollowDTO;
import com.projet.scootop.repository.services.interaction.FollowRepository;

import java.util.List;

@Service

public class FollowService {
	
    @Autowired private FollowRepository followRepository;
    @Autowired private FollowMapper mapper;
    
    public APIResultDTO add(FollowDTO followDTO){
        Follow follow = mapper.mapTo(followDTO);
        followRepository.save(follow);
        return new APIResultDTO("Success", null);
    }
    
    public FollowDTO get(Long id){
        Follow follow = followRepository.findById(id).orElse(null);
        if(follow==null){
            return null;
        }
        return mapper.mapToDTO(follow);
    }
    
    public List<FollowDTO> getAll(){

        List<Follow> follows = followRepository.findAll();
        return mapper.mapToDTO(follows);
    }
    
    public String delete(Long id){
        Follow follow = followRepository.findById(id).orElse(null);
        if(follow==null){
            return null;
        }

        followRepository.deleteById(id);

        return "Deleted";
    }

}
