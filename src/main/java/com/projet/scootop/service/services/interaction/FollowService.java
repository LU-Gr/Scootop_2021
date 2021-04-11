package com.projet.scootop.service.services.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.interaction.Follow;
import com.projet.scootop.model.services.interaction.FollowDTO;
import com.projet.scootop.repository.services.interaction.FollowRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class FollowService {
	
    @Autowired
    public FollowRepository followRepository;
    
    public FollowDTO add(FollowDTO followDTO){
        Follow follow= new Follow(followDTO.dateCreated,followDTO.user,followDTO.player,followDTO.saison);
        followRepository.save(follow);
        return followDTO;
    }
    
    public FollowDTO get(Long id){

        Follow follow = followRepository.findById(id).orElse(null);
        if(follow==null){
            return null;
        }
        FollowDTO followDTO = FollowDTO.get(follow.id,follow.dateCreated,follow.user,follow.player,follow.saison);
        return followDTO;
    }
    
    public List<FollowDTO> getAll(){

        List<Follow> follows = followRepository.findAll();
        System.out.println(follows.toArray());
        ArrayList<FollowDTO> followDTOArrayList = new ArrayList<>();
        for (Follow follow: follows
        ) {
            FollowDTO followDTO = FollowDTO.create(follow.dateCreated,follow.user,follow.player,follow.saison);
            followDTOArrayList.add(followDTO);

        }
        return followDTOArrayList;
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
