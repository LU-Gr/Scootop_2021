package com.projet.scootop.service.services.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.interaction.Invite;
import com.projet.scootop.mappers.services.interaction.InviteMapper;
import com.projet.scootop.model.APIResultDTO;
import com.projet.scootop.model.services.interaction.InviteDTO;
import com.projet.scootop.repository.services.interaction.InviteRepository;

import java.util.List;

@Service

public class InviteService {
	
    @Autowired private InviteRepository inviteRepository;
    @Autowired private InviteMapper mapper;
    
    public APIResultDTO add(InviteDTO inviteDTO){
        Invite invite = mapper.mapTo(inviteDTO);
        inviteRepository.save(invite);
        return new APIResultDTO("Success", null);
    }
    
    public InviteDTO get(Long id){
        Invite invite = inviteRepository.findById(id).orElse(null);
        if(invite==null){
            return null;
        }
        return mapper.mapToDTO(invite);
    }
    
    public List<InviteDTO> getAll(){
        List<Invite> invites = inviteRepository.findAll();
        return mapper.mapToDTO(invites);
    }
    
    public List<InviteDTO> getAllByUserId(Long id){
        List<Invite> invites = inviteRepository.findAllByUserId(id);
        return mapper.mapToDTO(invites);
    }
    
    public String delete(Long id){
        Invite invite = inviteRepository.findById(id).orElse(null);
        if(invite==null){
            return null;
        }

        inviteRepository.deleteById(id);
        return "Deleted";
    }

}
