package com.projet.scootop.scootop.service.services.interaction;

import com.projet.scootop.scootop.domain.services.interaction.Follow;
import com.projet.scootop.scootop.model.services.interaction.FollowDTO;
import com.projet.scootop.scootop.repository.services.interaction.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    public FollowDTO get(Integer id){

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
    public String delete(Integer id){
        Follow follow = followRepository.findById(id).orElse(null);
        if(follow==null){
            return null;
        }

        followRepository.deleteById(id);

        return "Deleted";
    }

}
